package com.mind.weixin.pay.vo;


import com.mind.wxpay.response.Coupon;

import java.util.List;
import java.util.Map;

/**
 * 订单详细
 * Created by serv on 2014/9/12.
 */
public class Transaction extends TradeVo{

    private String id;

    /** 公众账号 ID */
    private String appId;

    /** 商户号 */
    private String mchId;

    /** 公众账号 ID */
    private String subAppId;

    /** 子商户号 */
    private String subMchId;

    /** 签名 */
    private String sign;

    /**
     * 长度：8192
     * 详细的商品列表
     */
    private String detail;

    /**
     * 符合 ISO 4217 标准的三位字母代
     码，默认人民币：CNY，其他值列
     */
    private String feeType = "CNY";

    /** 交易起始时间 yyyyMMddHHmmss*/
    private String timeStart ;

    /** 交易结束时间 yyyyMMddHHmmss*/
    private String timeExpire;

    /** 通知地址 */
    private String notifyUrl;

    /** 用户标识 trade_type 为=JSAPI 时，此参数必传，用户在商户 sub_appid 下的唯一标识*/
    private String subOpenId;

    /** 返回状态码 */
    private String returnCode;

    /** 返回信息 */
    private String returnMsg;

    /** 业务结果 */
    private String resultCode;

    /** 错误代码 */
    private String errCode;

    /** 错误代码描述 */
    private String errCodeDes;

    /** 预支付 ID */
    private String prepayId;

    /** 二维码链接 */
    private String codeUrl;

    /** 是否关注公众号 */
    private String isSubscribe;

    /** 是否关注子公众账号 */
    private String subIsSubscribe;

    /** 付款银行 */
    private String bankType;

    /**
     * 符合 ISO 4217 标准的三位字母代码，默认人民币：CNY
     */
    private String cashFeeType;

    /**
     * 订单现金支付金额
     */
    private int cashFee;

    /** 代金券或立
     减优惠 金额 “代金券或立减优惠” 金额<=订单总金额， 订
     单总金额-“ 代金券或立减优惠” 金额=现金支
     付金额 */
    private int couponFee;

    /** 微信订单号 */
    private String transactionId;

    /** 支付完成时间 */
    private String timeEnd;

    /**
     * 交易状态：
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVERSE—已冲正
     * REVOK—已撤销
     */
    private String tradeState;

    /** 代金券或立减优惠 使用数量 */
    private int couponCount;

    /**
     * 代金券
     */
    private List<Coupon> couponList;

    /**
     * 时间戳
     */
    private Long timeStamp = System.currentTimeMillis();

    /**
     * 只有当 tradeType 为 JSAPI 的时候signType和paySign等不为null
     * key为：
     * appId
     * timeStamp
     * nonceStr
     * packageStr
     * signType
     * paySign
     */
    private Map<String, String> jsapi;


    //================= method ===================//


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getSubIsSubscribe() {
        return subIsSubscribe;
    }

    public void setSubIsSubscribe(String subIsSubscribe) {
        this.subIsSubscribe = subIsSubscribe;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public int getCashFee() {
        return cashFee;
    }

    public void setCashFee(int cashFee) {
        this.cashFee = cashFee;
    }

    public int getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(int couponFee) {
        this.couponFee = couponFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Map<String, String> getJsapi() {
        return jsapi;
    }

    public void setJsapi(Map<String, String> jsapi) {
        this.jsapi = jsapi;
    }
}
