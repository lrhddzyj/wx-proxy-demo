package com.mind.wxpay.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.StatusAware;

import java.io.Serializable;

/**
 * 撤销订单返回
 * Created by serv on 2015/1/26.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReverseResponse implements StatusAware,Serializable {

    /** 公众账号 ID */
    @JacksonXmlProperty(localName = "appid")
    private String appId;

    /** 商户号*/
    @JacksonXmlProperty(localName = "mch_id")
    private String mchId;

    /** 公众账号 ID */
    @JacksonXmlProperty(localName = "sub_appid")
    private String subAppId;

    /** 子商户号 */
    @JacksonXmlProperty(localName = "sub_mch_id")
    private String subMchId;

    /** 随机字符串 */
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /** 签名 */
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

    /** 是否需要继续调用撤销，Y-需要，N-不需要 */
    @JacksonXmlProperty(localName = "recall")
    private String recall;


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

    public String getRecall() {
        return recall;
    }

    public void setRecall(String recall) {
        this.recall = recall;
    }
}
