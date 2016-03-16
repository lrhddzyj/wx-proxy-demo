package com.mind.weixin.pay.service;

import com.mind.config.vo.WxPayConfigVo;
//import com.mind.data.utils.page.PageConverterUtils;
//import com.mind.data.vo.page.PageVo;
//import com.mind.data.vo.page.PageableVo;
import com.mind.httpclient.command.Executors;
import com.mind.proxy.wx.command.pay.*;
import com.mind.weixin.pay.WxPayConstants;
import com.mind.weixin.pay.entity.TransactionDocument;
import com.mind.weixin.pay.vo.SendRedPackVo;
import com.mind.weixin.pay.vo.TradeVo;
import com.mind.weixin.pay.vo.Transaction;
import com.mind.wxpay.WxPayException;
import com.mind.wxpay.request.*;
import com.mind.wxpay.response.*;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by serv on 2014/12/3.
 */
@Service
public class WxPaymentServiceImpl extends BaseMessageService implements WxOfflinePaymentService,WxOnlinePaymentService,WxPayConstants {

//    public PageVo<Transaction> findOrders(String shopId,String storeId, Date startDate,Date endDate,PageableVo pageable){
//        DateTime timeStart = new DateTime(startDate);
//        DateTime timeEnd = new DateTime(endDate);
//        if(timeStart.getYear()!=timeEnd.getYear()){
//            throw new WxPayException(110,"不能跨年度查询!");
//        }
//        if(timeStart.isAfter(timeEnd.getMillis())){
//            throw new WxPayException(111,"起始时间不能晚于结束时间!");
//        }
//        if(timeStart.plusMonths(ORDER_MONTH_SIZE).isBefore(timeEnd.getMillis())){
//            throw new WxPayException(112,"只能查询半年内的数据!");
//        }
//        //结束时间第二天零点 相当于 结束时间的晚上24:00
//        Date _endDateZone = new LocalDate(timeEnd).plusDays(1).toDate();
//        //开始时间的当天早上0:00
//        Date _startDateZone = new LocalDate(timeEnd).toDate();
//
//        Page<TransactionDocument> pageList = findTransactions(shopId, storeId, _startDateZone, _endDateZone, PageConverterUtils.convert2PageRequest(pageable));
//        return PageConverterUtils.convert2PageVo(pageList, TransactionDocument.class, Transaction.class);
//    }
//


    public Transaction unifiedorder(TradeVo trade) {
        long _tempTime = System.currentTimeMillis();
        WxPayConfigVo wxPayConfigVo = getWxPayConfig(trade.getShopId(), trade.getStoreId(), trade.getTradeType());
        logger.info("----------获取微信支付配置: 耗时: {}",System.currentTimeMillis()-_tempTime);

        UnifiedorderRequest paymentVo = createRequest(trade, UnifiedorderRequest.class);
        logger.info("----------获取唯一订单号服务: 耗时: {}",System.currentTimeMillis()-_tempTime);

        TransactionDocument document = createTransactionDocument(trade, paymentVo);
        UnifiedorderResponse prePaymentMessage = Executors.build().exec(new UnifiedorderCmd(paymentVo, wxPayConfigVo.getKey())).getResponse();
        logger.info("----------微信返回订单结果: 耗时: {}",System.currentTimeMillis()-_tempTime);

        document = updateTransactionDocument(document, prePaymentMessage);
        logger.info("----------保存订单: 耗时: {}",System.currentTimeMillis()-_tempTime);

        return beanMapper.map(document, Transaction.class);
    }

    public Transaction micropay(TradeVo tradeVo) {
        WxPayConfigVo configByDeviceInfo = getWxPayConfig(tradeVo.getShopId(), tradeVo.getStoreId(), tradeVo.getTradeType());
        MicropayRequest microPaymentVo = createRequest(tradeVo, MicropayRequest.class);
        TransactionDocument document = createTransactionDocument(tradeVo, microPaymentVo);
        try{
            //发起刷卡支付
            MicropayResponse micropay = Executors.build().exec(new MicropayCmd(microPaymentVo,configByDeviceInfo.getKey())).getResponse();
            document = updateTransactionDocument(document, micropay);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return beanMapper.map(document, Transaction.class);
    }

    /**
     * 发起退款
     * @param outTradeNo
     */
    public RefundResponse refund(String outTradeNo,int refundFee){

        TransactionDocument document = findTransaction(outTradeNo);

        //获取当前商户的配置
        WxPayConfigVo config = getWxPayConfig(document.getShopId(), document.getStoreId(), document.getTradeType());

        byte[] cert = getCert(document.getShopId(), document.getStoreId(), document.getTradeType());
        RefundRequest refundVo = createRefundRequest(document, refundFee);

        RefundResponse refundMessage = Executors.build().exec(new RefundCmd(refundVo,config.getKey(),cert, config.getMchId())).getResponse();

        //更新转入退款状态
        document.setTradeState(WxPayTradeState.REFUND.name());
        updateTransactoinDocument(document);
        return refundMessage;
    }

    public RefundResponse refund(RefundRequest request,String key,byte[] cert){
        RefundResponse refundMessage = Executors.build().exec(new RefundCmd(request,key,cert, request.getMchId())).getResponse();
        return refundMessage;
    }


    public RefundQueryResponse refundQuery(String outTradeNo){
        TransactionDocument document = findTransaction(outTradeNo);
        WxPayConfigVo config = getWxPayConfig(document.getShopId(), document.getStoreId(), document.getTradeType());
        RefundQueryResponse refundQueryResponse = Executors.build()
                .exec(new RefundQueryCmd(beanMapper.map(document, RefundQueryRequest.class), config.getKey())).getResponse();
        return refundQueryResponse;
    }

    @Override
    public RefundQueryResponse refundQuery(RefundQueryRequest request,String key) {
        RefundQueryResponse refundQueryResponse = Executors.build()
                .exec(new RefundQueryCmd(request, key)).getResponse();
        return refundQueryResponse;
    }

    public CloseOrderResponse closeOrder(String outTradeNo){
        TransactionDocument document = findTransaction(outTradeNo);
        WxPayConfigVo config = getWxPayConfig(document.getShopId(), document.getStoreId(), document.getTradeType());
        return Executors.build().exec(new CloseOrderCmd(beanMapper.map(document, CloseOrderRequest.class),config.getKey())).getResponse();
    }


    public String downLoadOnlineBill(String shopId,String billDate){
        WxPayConfigVo config = getWxPayConfig(shopId, null, "JSAPI");
        return downLoadBill(config, null, billDate);
    }

    @Override
    public String downLoadShopBill(String configId,String billDate){
        WxPayConfigVo wxPayConfigVo = getWxPayConfigById(configId);

        return downLoadBill(wxPayConfigVo,null,billDate);
    }



    public String downLoadOfflineBill(String shopId,String storeId,String deviceInfo,String billDate){
        WxPayConfigVo config = getWxPayConfig(shopId, storeId, "NATIVE");
        return downLoadBill(config,deviceInfo,billDate);
    }



    public ReverseResponse reverse(String outTradeNo) {
        TransactionDocument document = findTransaction(outTradeNo);
        //发起撤销
        WxPayConfigVo config = getWxPayConfig(document.getShopId(), document.getStoreId(), document.getTradeType());
        byte[] cert = getCert(document.getShopId(),document.getStoreId(),document.getTradeType());
        ReverseResponse reverse = Executors.build().exec(new ReverseCmd(beanMapper.map(document,ReverseRequest.class),config.getKey(),cert,config.getMchId())).getResponse();
        if(StringUtils.equals(reverse.getRecall(),"N")){
            document.setTradeState(WxPayTradeState.REVOKED.name());
            updateTransactoinDocument(document);
        }
        return reverse;
    }

    public Transaction getTransactionByOutTradeNo(String outTradeNo){
        TransactionDocument document = getAndSynTransactionDocument(outTradeNo);
        return beanMapper.map(document,Transaction.class);
    }

    public List<Transaction> findByBusinessSystemId(String businessSystemId){
        List<TransactionDocument> documents = transactionRepository.findByBusinessSystemId(businessSystemId);
        return beanMapper.mapAsList(documents,Transaction.class);
    }

    @Override
    public Transaction sendRedPack(SendRedPackVo sendRedPackVo) throws WxPayException {
        String companyId = sendRedPackVo.getCompanyId();
        WxPayConfigVo wxPayConfigVo = getWxPayConfigById(companyId);

        String nonceStr = StringUtils.remove(UUID.randomUUID().toString(), "-");

        SendRedPackRequest sendRedPackRequest = new SendRedPackRequest();
        sendRedPackRequest.setMchId(wxPayConfigVo.getMchId());
        sendRedPackRequest.setWxAppId(wxPayConfigVo.getAppId());

        sendRedPackRequest.setClientIp("127.0.0.1");
        sendRedPackRequest.setMchBillno(StringUtils.remove(UUID.randomUUID().toString(),"-").substring(0,27));
        sendRedPackRequest.setNonceStr(nonceStr);
        sendRedPackRequest.setRemark(sendRedPackVo.getRemark());
        sendRedPackRequest.setReOpenId(sendRedPackVo.getOpenId());
        sendRedPackRequest.setSendName(wxPayConfigVo.getCompanyName());
        sendRedPackRequest.setTotalAmount(sendRedPackVo.getTotalAmount());
        sendRedPackRequest.setTotalNum(1);
        sendRedPackRequest.setWishing(sendRedPackVo.getWishing());
        sendRedPackRequest.setActName(sendRedPackVo.getActName());

        byte[] cert = getCert(sendRedPackVo.getCompanyId(), null, null);

        TransactionDocument document = new TransactionDocument();
        document.setAppId(sendRedPackVo.getAppId());
        document.setOpenId(sendRedPackVo.getOpenId());
        document.setShopId(sendRedPackVo.getCompanyId());
        document.setNonceStr(nonceStr);
        document.setBusinessSystemId(sendRedPackVo.getBusinessId());
        document.setMchId(wxPayConfigVo.getMchId());
        document.setTotalFee(sendRedPackVo.getTotalAmount());
        document.setAppCode(sendRedPackVo.getAppCode());
        document.setTradeState(WxPayTradeState.NOTPAY.name());
        document.setTradeType("RED_PACK");

        transactionRepository.save(document);

        SendRedPackResponse response = Executors.build().exec(new SendRedPackCmd(sendRedPackRequest, wxPayConfigVo.getKey(), cert, wxPayConfigVo.getMchId())).getResponse();
//        document = updateTransactionDocument(document, response);

        beanMapper.map(response, document);
        transactionRepository.save(document);
        return beanMapper.map(document, Transaction.class);

    }


}

