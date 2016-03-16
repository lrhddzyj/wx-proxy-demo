package com.mind.wxpay.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.StatusAware;

import java.io.Serializable;

/**
 * Created by lrh on 2015/12/12.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SendRedPackResponse implements StatusAware,Serializable {

    /**返回状态码**/
    @JacksonXmlProperty(localName = "return_code")
    private String returnCode;

    /**返回信息**/
    @JacksonXmlProperty(localName = "return_msg")
    private String returnMsg;

    /**业务结果**/
    @JacksonXmlProperty(localName = "result_code")
    private String resultCode;

    /**错误代码**/
    @JacksonXmlProperty(localName = "err_code")
    private String errCode;

    /**错误代码描述**/
    @JacksonXmlProperty(localName = "err_code_des")
    private String errCodeDes;

    /**商户订单号**/
    @JacksonXmlProperty(localName = "mch_billno")
    private String mchBillno;

    /**商户号**/
    @JacksonXmlProperty(localName = "mch_id")
    private String mchId;

    /**公众账号appid**/
    @JacksonXmlProperty(localName = "wxappid")
    private String wxAppId;

    /**用户openid**/
    @JacksonXmlProperty(localName = "re_openid")
    private String reOpenId;

    /**付款金额**/
    @JacksonXmlProperty(localName = "total_amount")
    private int totalAmount ;

    /**发放成功时间**/
    @JacksonXmlProperty(localName = "send_time")
    private long sendTime;

    /**微信单号**/
    @JacksonXmlProperty(localName = "send_listid")
    private String sendListId;

    /**签名**/
    @JacksonXmlProperty(localName = "sign")
    private String sign;


    @Override
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @Override
    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Override
    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
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

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendListId() {
        return sendListId;
    }

    public void setSendListId(String sendListId) {
        this.sendListId = sendListId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
