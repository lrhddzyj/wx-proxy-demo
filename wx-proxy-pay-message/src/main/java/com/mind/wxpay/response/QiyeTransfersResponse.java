package com.mind.wxpay.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

/**
 * Created by serv on 2015/5/7.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QiyeTransfersResponse implements Serializable {

    /** 返回状态码 */
    @JacksonXmlProperty(localName = "return_code")
    private String returnCode;

    /** 返回信息 */
    @JacksonXmlProperty(localName = "return_msg")
    private String returnMsg;

    /** 商户appid */
    @JacksonXmlProperty(localName = "mch_appid")
    private String mchAppid;

    /** 商户号 */
    @JacksonXmlProperty(localName = "mchid")
    private String mchid;

    /** 设备号 */
    @JacksonXmlProperty(localName = "device_info")
    private String deviceInfo;

    /** 随机字符串 */
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /** 签名 */
    @JacksonXmlProperty(localName = "sign")
    private String sign;

    /** 业务结果 */
    @JacksonXmlProperty(localName = "result_code")
    private String resultCode;

    /** 错误代码 */
    @JacksonXmlProperty(localName = "err_code")
    private String errCode;

    /** 错误代码描述 */
    @JacksonXmlProperty(localName = "err_code_des")
    private String errCodeDes;

    /** 商户订单号 */
    @JacksonXmlProperty(localName = "partner_trade_no")
    private String partnerTradeNo;

    /** 微信订单号 */
    @JacksonXmlProperty(localName = "payment_no")
    private String paymentNo;

    /** 微信成功时间 */
    @JacksonXmlProperty(localName = "payment_time")
    private String paymentTime;

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

    public String getMchAppid() {
        return mchAppid;
    }

    public void setMchAppid(String mchAppid) {
        this.mchAppid = mchAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
