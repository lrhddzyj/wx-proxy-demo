package com.mind.wxpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mind.wxpay.aware.SignPostAware;

import java.io.Serializable;

/**
 * 短链接请求
 * Created by serv on 2015/1/26.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShortUrlRequest implements SignPostAware,Serializable {

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

    /** 随机字符串 */
    @JacksonXmlProperty(localName = "nonce_str")
    private String nonceStr;

    /** 签名 */
    @JacksonXmlProperty(localName = "sign")
    private String sign;

    /** url链接 */
    @JacksonXmlProperty(localName = "long_url")
    private String longUrl;

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

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
