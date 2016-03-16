package com.mind.wxpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.OutTradeNoAutoGenerateAware;
import com.mind.wxpay.aware.SignPostAware;

import java.io.Serializable;

/**
 * 小额支付
 * Created by serv on 2015/1/23.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MicropayRequest implements SignPostAware,OutTradeNoAutoGenerateAware,Serializable {

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

    /** 商品描述 (必填)*/
    @JacksonXmlProperty(localName = "body")
    private String body;

    /**
     * 长度：8192
     * 详细的商品列表
     */
    @JacksonXmlProperty(localName = "detail")
    private String detail;

    /** 附加数据 */
    @JacksonXmlProperty(localName = "attach")
    private String attach;

    /** 商户订单号 (必填)*/
    @JacksonXmlProperty(localName = "out_trade_no")
    private String outTradeNo;

    /**
     * 符合 ISO 4217 标准的三位字母代
     码，默认人民币：CNY，其他值列
     */
    @JacksonXmlProperty(localName = "fee_type")
    private String feeType = "CNY";

    /** 总金额 (必填)*/
    @JacksonXmlProperty(localName = "total_fee")
    private int totalFee;

    /** 终端 IP  (必填)*/
    @JacksonXmlProperty(localName = "spbill_create_ip")
    private String spbillCreateIp = "127.0.0.1";

    /** 交易起始时间 yyyyMMddHHmmss*/
    @JacksonXmlProperty(localName = "time_start")
    private String timeStart ;

    /** 交易结束时间 yyyyMMddHHmmss*/
    @JacksonXmlProperty(localName = "time_expire")
    private String timeExpire;

    /** 商品标记 */
    @JacksonXmlProperty(localName = "goods_tag")
    private String goodsTag;

    @JacksonXmlProperty(localName = "auth_code")
    private String authCode;


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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
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

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
