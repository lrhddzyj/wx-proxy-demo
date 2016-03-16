package com.mind.weixin.pay.service;

import com.mind.config.service.WxPayConfigService;
//import com.mind.config.service.WxPayOfflineConfigService;
//import com.mind.config.service.WxPayOnlineConfigService;
import com.mind.config.vo.WxPayConfigVo;
import com.mind.httpclient.command.Executors;
import com.mind.proxy.wx.command.pay.DownloadbillCmd;
import com.mind.proxy.wx.command.pay.OrderqueryCmd;
import com.mind.proxy.wx.utils.SignUtils;
//import com.mind.redis.no.service.OutTradeNoService;
import com.mind.weixin.pay.entity.TransactionDocument;
import com.mind.weixin.pay.repository.TransactionRepository;
import com.mind.weixin.pay.utils.BeanMapper;
import com.mind.weixin.pay.vo.TradeVo;
import com.mind.wxpay.aware.JsApiOpenIdAware;
import com.mind.wxpay.aware.NotifyUrlAware;
import com.mind.wxpay.aware.OutTradeNoAutoGenerateAware;
import com.mind.wxpay.aware.StatusAware;
import com.mind.wxpay.request.BillQueryRequest;
import com.mind.wxpay.request.OrderQueryRequest;
import com.mind.wxpay.request.RefundRequest;
import com.mind.wxpay.response.MicropayResponse;
import com.mind.wxpay.response.OrderQueryResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by serv on 2014/12/30.
 */
public abstract class BaseMessageService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    protected TransactionRepository transactionRepository;
    @Autowired
    protected BeanMapper beanMapper;
//    @Autowired
//    private WxPayOnlineConfigService wxPayOnlineConfigService;
//    @Autowired
//    private WxPayOfflineConfigService wxPayOfflineConfigService;

    @Autowired
    WxPayConfigService wxPayConfigService;
//    @Autowired
//    private OutTradeNoService outTradeNoService;
    @Value("${notify.url}")
    private String notifyUrl;


    /**
     * 本地线程保存微信支付相关配置
     */
    private transient ThreadLocal<WxPayConfigVo> wxPayConfigVoThreadLocal = new ThreadLocal<WxPayConfigVo>();

    /**
     * 获取订单,不同步微信
     * @param outTradeNo
     * @return
     */
    protected TransactionDocument findTransaction(String outTradeNo){
        TransactionDocument document = transactionRepository.findByOutTradeNo(outTradeNo);
        Assert.notNull(document, "没有找到订单");
        return document;
    }

    /**
     * 通过业务请求信息和微信请求信息和微信响应消息 组装 订单对象 并保存
     * @param tradeVo 业务请求对象
     * @param paymentVo 微信请求对象
     * @return 订单对象
     */
    protected TransactionDocument createTransactionDocument(TradeVo tradeVo,Object paymentVo){
        //复制业务请求信息
        TransactionDocument document = beanMapper.map(tradeVo, TransactionDocument.class);
        //复制微信请求支付信息
        beanMapper.map(paymentVo,document);
        document.setTradeState(WxPayTradeState.NOTPAY.name());
        return transactionRepository.save(document);
    }
    /**
     * 通过业务请求信息和微信请求信息和微信响应消息 组装 订单对象 并保存
     * @param document 订单文档
     * @param wxResponseMessage 微信响应对象
     * @return 订单对象
     */
    protected TransactionDocument updateTransactionDocument(TransactionDocument document,StatusAware wxResponseMessage){
        //复制预支付订单信息
        beanMapper.map(wxResponseMessage, document);
        //根据返回的预支付订单号生成jsapi签名
        if (document.getTradeType().equals("JSAPI")){
            signTransaction(document, this.wxPayConfigVoThreadLocal.get().getKey());
        }
        //小额支付情况下回直接返回postPaymentMessage对象
        if(wxResponseMessage instanceof MicropayResponse){
            MicropayResponse micropay = (MicropayResponse) wxResponseMessage;
            if(micropay.getReturnCode().equals("SUCCESS")&&micropay.getResultCode().equals("SUCCESS")){
                document.setTradeState(WxPayTradeState.SUCCESS.name());
            }
        }
        return transactionRepository.save(document);
    }

    /**
     * 线上支付 sign签名 并且保存到相关信息到 transaction
     * @param transaction
     * @param key
     */
    private void signTransaction(TransactionDocument transaction , String key) {
        String packageStr = "prepay_id=" + transaction.getPrepayId();
        String signType = "MD5" ;
        transaction.setPackageStr(packageStr);
        transaction.setSignType(signType);

        SortedMap<String , String> resultMap = new TreeMap<String, String>();
        resultMap.put("appId", transaction.getAppId());
        resultMap.put("timeStamp" , transaction.getTimeStamp().toString());
        resultMap.put("nonceStr", transaction.getNonceStr());
        resultMap.put("package" , packageStr);
        resultMap.put("signType", signType);
        String paySign = SignUtils.encodeSign(resultMap, key);
        transaction.setPaySign(paySign);
    }


    protected void updateTransactoinDocument(TransactionDocument document){
        Assert.notNull(document.getId(),"没有id,document无法更新,检查是否应该是新增");
        transactionRepository.save(document);
    }

    protected Page<TransactionDocument> findTransactions(String shopId, String storeId, Date startDateZone, Date endDateZone, Pageable pageable) {
        Page<TransactionDocument> byShopIdAndStoreId;
        if(StringUtils.isEmpty(storeId)){
            byShopIdAndStoreId = transactionRepository.findByShopId(shopId, startDateZone, endDateZone, pageable);
        }else{
            byShopIdAndStoreId = transactionRepository.findByShopIdAndStoreId(shopId,storeId, startDateZone, endDateZone, pageable);
        }
        return byShopIdAndStoreId;
    }

    /**
     * 创建微信请求对象
     */
    protected  <T> T createRequest(TradeVo tradeVo, Class<T> tClass){
        WxPayConfigVo configVo = this.wxPayConfigVoThreadLocal.get();
        T vo = beanMapper.map(tradeVo, tClass);

        beanMapper.map(configVo, vo);

        if(vo instanceof JsApiOpenIdAware){
            if(StringUtils.isNoneEmpty(((JsApiOpenIdAware) vo).getSubMchId())){
                //将openId放入 subOpenId中
                ((JsApiOpenIdAware) vo).setSubOpenId(((JsApiOpenIdAware) vo).getOpenId());
                ((JsApiOpenIdAware) vo).setOpenId(null);
            }
        }
        //统一支付需要
        if(vo instanceof NotifyUrlAware){
            ((NotifyUrlAware)vo).setNotifyUrl(notifyUrl);
        }
        //已经复制过了
//        if (tClass.isAssignableFrom(MicroPaymentVo.class)){
//            ((MicroPaymentVo)vo).setAuthCode(tradeVo.getAuthCode());
//        }
        //设置商户内部订单号
        if(vo instanceof OutTradeNoAutoGenerateAware){
            if(StringUtils.isEmpty(((OutTradeNoAutoGenerateAware) vo).getOutTradeNo())){
                ((OutTradeNoAutoGenerateAware) vo).setOutTradeNo(StringUtils.remove(UUID.randomUUID().toString(), "-").substring(0,30)
//                        outTradeNoService.getOutTradeNo(configVo.getShopId())
                );
            }
        }
        return  vo;
    }

    /**
     * 创建退款请求
     * @param document
     * @param refundFee
     * @return
     */
    protected RefundRequest createRefundRequest(TransactionDocument document, int refundFee){
        WxPayConfigVo configVo = this.wxPayConfigVoThreadLocal.get();
        RefundRequest refundVo = beanMapper.map(document,RefundRequest.class);
        refundVo.setNonceStr(StringUtils.remove(UUID.randomUUID().toString(), "-"));
        refundVo.setOpUserId(configVo.getMchId());//默认用商户号当操作者
        //根据预退款的单子上的金额,发起微信退款
        refundVo.setRefundFee(refundFee);
        refundVo.setOutRefundNo(StringUtils.remove(UUID.randomUUID().toString(), "-"));//商户内部的退款单号
        //TODO 为什么不支持CNY
        refundVo.setFeeType(null);

        return refundVo;
    }


    /**
     * 获取并且跟微信官方同步订单信息
     * @param outTradeNo
     * @return
     */
    protected TransactionDocument getAndSynTransactionDocument(String outTradeNo) {
        TransactionDocument document = findTransaction(outTradeNo);
        OrderQueryRequest orderVo = beanMapper.map(document,OrderQueryRequest.class);
        orderVo.setNonceStr(StringUtils.remove(UUID.randomUUID().toString(), "-"));
        WxPayConfigVo wxPayConfigVo = getWxPayConfig(document.getShopId(),document.getStoreId(),document.getTradeType());
        OrderQueryResponse orderMessage = Executors.build().exec(new OrderqueryCmd(orderVo,wxPayConfigVo.getKey())).getResponse();
        //如果交易记录中 没有保存 subOpenId 或者 订单状态不一致 ， 则同步微信的订单信息
        if(StringUtils.isEmpty(document.getSubOpenId())||
                !StringUtils.equals(orderMessage.getTradeState(),document.getTradeState())){
            beanMapper.map(orderMessage,document);
            //微信支付成功后.如果不是代理商模式，则推送的xml的子商户跟主商户一样了.这里排除这个逻辑
            if(StringUtils.equals(document.getMchId(), document.getSubMchId())){
                document.setSubMchId(null);
            }
            transactionRepository.save(document);
        }
        return document;
    }

    /**
     * 获取支付配置,并且设置到本地线程中
     * @param shopId 商家id
     * @param storeId 门店id
     * @param tradeType 支付类型
     * @return
     */
    protected WxPayConfigVo getWxPayConfig(String shopId,String storeId,String tradeType){
        WxPayConfigVo configVo = wxPayConfigService.getWxPayConfig(shopId);
//        if(tradeType.equals("JSAPI")){
//            configVo = wxPayOnlineConfigService.getWxPayOnlineConfig(shopId);
//        }else{
//            configVo = wxPayOfflineConfigService.getWxPayOfflineConfig(shopId, storeId);
//        }
        Assert.notNull(configVo, "找不到支付配置");
        this.wxPayConfigVoThreadLocal.set(configVo);
        return configVo;
    }

    /**
     * 根据配置ID获取配置信息，并放在本地线程中
     * @param configId
     * @return
     */
    protected WxPayConfigVo getWxPayConfigById(String configId){
//        WxPayConfigVo configVo = wxPayOfflineConfigService.getWxPayOfflineById(configId);
        WxPayConfigVo configVo =  wxPayConfigService.getWxPayConfig(configId);
        Assert.notNull(configVo, "找不到支付配置");
        this.wxPayConfigVoThreadLocal.set(configVo);
        return configVo;
    }



    /**
     * 获取支付证书
     * @param shopId 商家id
     * @param storeId 门店id
     * @param tradeType 支付类型
     * @return
     */
    protected byte[] getCert(String shopId , String storeId , String tradeType) {

        byte[] cert = wxPayConfigService.getCert(shopId);
//        if(tradeType.equals("JSAPI")){
//            cert = wxPayOnlineConfigService.getCertOnline(shopId);
//        }else{
//            cert = wxPayOfflineConfigService.getCertOffline(shopId, storeId);
//        }
        Assert.notNull(cert, "找不到微信支付的退款证书");
        return cert;
    }

    /**
     * 下载对账单
     * @param configVo 微信配置信息
     * @param deviceInfo 微信支付分配的终端设备号，填写此字段，只下载该设备号的对账单
     * @param billDate 下载对账单的日期，格式：20140603
     * @return
     */
    protected String downLoadBill(WxPayConfigVo configVo,String deviceInfo,String billDate){
        BillQueryRequest request = beanMapper.map(configVo,BillQueryRequest.class);
        request.setDeviceInfo(deviceInfo);
        request.setBillDate(billDate);
        request.setBillType("ALL");
        return Executors.build().exec(new DownloadbillCmd(request,configVo.getKey())).getResponse();
    }

}
