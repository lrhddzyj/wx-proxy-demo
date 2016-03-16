package com.mind.wxpay.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.CouponListAware;
import com.mind.wxpay.aware.StatusAware;

import java.io.Serializable;
import java.util.List;

/**
 * 退款返回
 * Created by serv on 2015/1/23.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RefundResponse implements StatusAware,CouponListAware,Serializable {

    /** 公众账号 ID (必填)*/
    @JacksonXmlProperty(localName = "appid")
    private String appId;

    /** 商户号 (必填)*/
    @JacksonXmlProperty(localName = "mch_id")
    private String mchId;

    /** 公众账号 ID */
    @JacksonXmlProperty(localName = "sub_appid")
    private String subAppId;

    /** 子商户号 */
    @JacksonXmlProperty(localName = "sub_mch_id")
    private String subMchId;

    /** 设备号 */
    @JacksonXmlProperty(localName = "device_info")
    private String deviceInfo;

    /** 随机字符串 (必填)*/
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /** 签名 (必填)*/
    @JacksonXmlProperty(localName = "sign")
    private String sign;

    /** 返回状态码 */
    @JacksonXmlProperty(localName = "return_code")
    private String returnCode;

    /** 返回信息 */
    @JacksonXmlProperty(localName = "return_msg")
    private String returnMsg;

    /** 业务结果 */
    @JacksonXmlProperty(localName = "result_code")
    private String resultCode;

    /** 错误代码 */
    @JacksonXmlProperty(localName = "err_code")
    private String errCode;

    /** 错误代码描述 */
    @JacksonXmlProperty(localName = "err_code_des")
    private String errCodeDes;

    /** 货币种类 */
    @JacksonXmlProperty(localName = "fee_type")
    private String feeType;

    /** 总金额 */
    @JacksonXmlProperty(localName = "total_fee")
    private String totalFee;

    /**
     * 符合 ISO 4217 标准的三位字母代码，默认人民币：CNY
     */
    @JacksonXmlProperty(localName = "cash_fee_type")
    private String cashFeeType;

    /**
     * 订单现金支付金额
     */
    @JacksonXmlProperty(localName = "cash_fee")
    private String cashFee;

    /** 微信订单号 */
    @JacksonXmlProperty(localName = "transaction_id")
    private String transactionId;

    /** 商户订单号 */
    @JacksonXmlProperty(localName = "out_trade_no")
    private String outTradeNo;

    /** 代金券或立减优惠 使用数量 */
    @JacksonXmlProperty(localName = "coupon_count")
    private int couponCount;

    /**
     * 代金券
     */
    private List<Coupon> couponList;

    /** 商户退款单号 */
    @JacksonXmlProperty(localName = "out_refund_no")
    private String outRefundNo;

    /** 退款金额 */
    @JacksonXmlProperty(localName = "refund_fee")
    private int refundFee;

    /** 微信退款单号 */
    @JacksonXmlProperty(localName = "refund_id")
    private String refundId;

    /** 现金退款金额，单位为分，只能为整数 */
    @JacksonXmlProperty(localName = "cash_refund_fee")
    private String cashRefundFee;

    /** “ 代金券或立减优惠 ”退款金额=订单金额-现金退款金额，注意： 立减优惠 金额不会退回 */
    @JacksonXmlProperty(localName = "coupon_refund_fee")
    private int couponRefundFee;

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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(String cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }

    public int getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(int couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }
}
