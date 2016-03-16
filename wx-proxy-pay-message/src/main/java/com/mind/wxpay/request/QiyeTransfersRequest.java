package com.mind.wxpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.SignPostAware;

import java.io.Serializable;

/**
 * 企业付款
 * Created by serv on 2015/5/7.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QiyeTransfersRequest implements SignPostAware,Serializable {

    /** 公众账号appid   */
    @JacksonXmlProperty(localName = "mch_appid")
    private String mchAppid;

    /** 商户号   */
    @JacksonXmlProperty(localName = "mchid")
    private String mchid;

    /** 子商户号   */
    @JacksonXmlProperty(localName = "sub_mch_id")
    private String subMchId;

    /** 设备号   */
    @JacksonXmlProperty(localName = "device_info")
    private String deviceInfo;

    /** 随机字符串     */
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /** 签名   */
    @JacksonXmlProperty(localName = "sign")
    private String sign;

    /** 商户订单号 */
    @JacksonXmlProperty(localName = "partner_trade_no")
    private String partnerTradeNo;

    /** 用户openid */
    @JacksonXmlProperty(localName = "openid")
    private String openid;

    /** 校验用户姓名选项 */
    @JacksonXmlProperty(localName = "check_name")
    private String checkName;

    /** 收款用户姓名 */
    @JacksonXmlProperty(localName = "re_user_name")
    private String reUserName;

    /** 金额 */
    @JacksonXmlProperty(localName = "amount")
    private int amount;

    /** 企业付款描述信息 */
    @JacksonXmlProperty(localName = "desc")
    private String desc;

    /** Ip地址 */
    @JacksonXmlProperty(localName = "spbill_create_ip")
    private String spbillCreateIp;


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

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getReUserName() {
        return reUserName;
    }

    public void setReUserName(String reUserName) {
        this.reUserName = reUserName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
}
