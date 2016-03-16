package com.mind.weixin.pay.service;

//import com.mind.data.vo.page.PageVo;
//import com.mind.data.vo.page.PageableVo;
import com.mind.weixin.pay.vo.SendRedPackVo;
import com.mind.weixin.pay.vo.TradeVo;
import com.mind.weixin.pay.vo.Transaction;
import com.mind.wxpay.WxPayException;
import com.mind.wxpay.request.RefundQueryRequest;
import com.mind.wxpay.request.RefundRequest;
import com.mind.wxpay.response.CloseOrderResponse;
import com.mind.wxpay.response.RefundQueryResponse;
import com.mind.wxpay.response.RefundResponse;
import com.mind.wxpay.response.SendRedPackResponse;

import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2014/12/3.
 */
public interface WxOnlinePaymentService {

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
     * 退款
     * @param outTradeNo 订单号
     * @param refundFee 退款金额(单位:分)
     * @return
     */
    public RefundResponse refund(String outTradeNo, int refundFee) throws WxPayException;

    /**
     * 查询当前订单的退款详情
     * @param outTradeNo
     * @return
     */
    public RefundQueryResponse refundQuery(String outTradeNo) throws WxPayException;

    /**
     * 退款
     * @param request 原生请求
     * @param key 签名秘钥
     * @param cert 退款证书
     * @return 退款结果
     */
    public RefundResponse refund(RefundRequest request, String key, byte[] cert) throws WxPayException;

    /**
     * 退款查询
     * @param request
     * @return
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request, String key) throws WxPayException;
    /**
     * 关闭订单，防止误支付
     * @param outTradeNo
     * @return
     */
    public CloseOrderResponse closeOrder(String outTradeNo) throws WxPayException;

    /**
     * 下载对账单
     * @param shopId 商家id
     * @param billDate 下载对账单的日期，格式：20140603
     * @return
     */
    public String downLoadOnlineBill(String shopId, String billDate) throws WxPayException;


    /**
     * 根据订单号获取订单详情
     * @param outTradeNo 订单号
     * @return
     */
    public Transaction getTransactionByOutTradeNo(String outTradeNo) throws WxPayException;

    /**
     * 根据业务主键获取订单列表
     * @param businessSystemId
     * @return
     */
    public List<Transaction> findByBusinessSystemId(String businessSystemId) throws WxPayException;


    /**
     * 发送红包接口
     * @param sendRedPackVo
     * @return
     * @throws WxPayException
     */
    public Transaction sendRedPack(SendRedPackVo sendRedPackVo) throws WxPayException;



}
