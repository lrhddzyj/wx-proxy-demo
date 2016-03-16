package com.mind.wxpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.SignPostAware;
import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;

import java.io.Serializable;

/**
 * Created by lrh on 2015/12/12.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SendRedPackRequest implements SignPostAware,Serializable {


    /**随机字符串(必填)**/
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /**签名(必填)**/
    @JacksonXmlProperty(localName = "sign")
    private String sign;

    /**商户订单号(必填)**/
    @JacksonXmlProperty(localName = "mch_billno")
    private String mchBillno;

    /**商户订单号(必填)**/
    @JacksonXmlProperty(localName = "mch_id")
    private String mchId;

    /**微信公众号appid(必填)**/
    @JacksonXmlProperty(localName = "wxappid")
    private String wxAppId;

   /**商户名称（必填）**/
    @JacksonXmlProperty(localName = "send_name")
    private String  sendName;

    /**用户openid（必填）**/
    @JacksonXmlProperty(localName = "re_openid")
    private String reOpenId;

    /**付款金额(必填)**/
    @JacksonXmlProperty(localName = "total_amount")
    private int totalAmount;

    /**红包发放总人数(必填)**/
    @JacksonXmlProperty(localName = "total_num")
    private int totalNum;

    /**红包祝福语（必填）**/
    @JacksonXmlProperty(localName = "wishing")
    private String wishing;

    /**Ip地址（必填）**/
    @JacksonXmlProperty(localName = "client_ip")
    private String clientIp;

    /**活动名称（必填）**/
    @JacksonXmlProperty(localName = "act_name")
    private String actName;

    /**备注（必填）**/
    @JacksonXmlProperty(localName = "remark")
    private String remark;


    public String getSign() {
        return sign;
    }

    public String getMchBillno() {
        return mchBillno;
    }

    public void setMchBillno(String mchBillno) {
        this.mchBillno = mchBillno;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReOpenId() {
        return reOpenId;
    }

    public void setReOpenId(String reOpenId) {
        this.reOpenId = reOpenId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getNonceStr() {
        return nonceStr;
    }


    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }


    public void setSign(String sign) {
        this.sign = sign;
    }
}
