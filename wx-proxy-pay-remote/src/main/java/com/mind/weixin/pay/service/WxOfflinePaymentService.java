package com.mind.weixin.pay.service;

//import com.mind.data.vo.page.PageVo;
//import com.mind.data.vo.page.PageableVo;
import com.mind.weixin.pay.vo.TradeVo;
import com.mind.weixin.pay.vo.Transaction;
import com.mind.wxpay.WxPayException;
import com.mind.wxpay.request.RefundQueryRequest;
import com.mind.wxpay.request.RefundRequest;
import com.mind.wxpay.response.CloseOrderResponse;
import com.mind.wxpay.response.RefundQueryResponse;
import com.mind.wxpay.response.RefundResponse;
import com.mind.wxpay.response.ReverseResponse;

import java.util.Date;
import java.util.List;

/**
 * Created by rocky on 15/1/7.
 */
public interface WxOfflinePaymentService {

    /**
     * 发起统一支付
     * @param trade
     * @return
     */
    public Transaction unifiedorder(TradeVo trade) throws WxPayException;

    /**
     * 分页查询支付信息
     * @param shopId 商家id
     * @param storeId 门店id
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param pageable 分页对象
     * @return
     */
//    public PageVo<Transaction> findOrders(String shopId, String storeId, Date startDate, Date endDate, PageableVo pageable) throws WxPayException;

    /**
     * 撤销订单
     * @param outTradeNo 订单号
     * @return 是否撤销成功 成功true 失败false 失败情况下, 需要重新发起调用
     */
    public ReverseResponse reverse(String outTradeNo) throws WxPayException;

    /**
     * 退款
     * @param outTradeNo 订单号
     * @param refundFee 退款金额(单位:分)
     * @return
     */
    public RefundResponse refund(String outTradeNo, int refundFee) throws WxPayException;

    /**
     * 退款
     * @param request 原生请求
     * @param key 签名秘钥
     * @param cert 退款证书
     * @return 退款结果
     */
    public RefundResponse refund(RefundRequest request, String key, byte[] cert);

    /**
     * 查询当前订单的退款详情
     * @param outTradeNo
     * @return
     */
    public RefundQueryResponse refundQuery(String outTradeNo);

    /**
     * 退款查询
     * @param request
     * @return
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request, String key);

    /**
     * 关闭订单，防止误支付
     * @param outTradeNo
     * @return
     */
    public CloseOrderResponse closeOrder(String outTradeNo);


    /**
     * 下载对账单
     * @param configId 商家的配置信息的Id
     * @param billDate 下载对账单的日期，格式：20140603
     * @return
     */
    String downLoadShopBill(String configId, String billDate);

    /**
     * 下载对账单
     * @param shopId 商家id
     * @param storeId 门店id
     * @param deviceInfo 终端设备号，填写此字段，只下载该设备号的对账单，否则下载商家当前全部的
     * @param billDate 下载对账单的日期，格式：20140603
     * @return
     */
    public String downLoadOfflineBill(String shopId, String storeId, String deviceInfo, String billDate);


    /**
     * 根据订单号获取订单详情
     * @param outTradeNo 订单号
     * @return
     */
    public Transaction getTransactionByOutTradeNo(String outTradeNo) throws WxPayException;

    /**
     * 小额支付
     * @param vo
     * @return
     */
    public Transaction micropay(TradeVo vo) throws WxPayException;

    /**
     * 根据业务主键获取订单列表
     * @param businessSystemId
     * @return
     */
    public List<Transaction> findByBusinessSystemId(String businessSystemId);
}
