package com.mind.weixin.pay.entity;


import com.mind.weixin.pay.vo.Transaction;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serv on 2014/9/12.
 */
@Document
public class TransactionDocument extends Transaction{
    @Id
    private String id;

    private String nonceStr ;

    private String packageStr ;

    private String signType ;

    private String paySign ;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Transient
    @Override
    public Map<String, String> getJsapi() {
        Map<String , String> jsapiMap = new HashMap<String, String>();
        jsapiMap.put("nonceStr" , nonceStr);
        jsapiMap.put("appId" , getAppId());
        jsapiMap.put("successCallbackUrl" , getSuccessCallbackUrl());
        jsapiMap.put("errCallbackUrl" , getErrCallbackUrl());
        jsapiMap.put("cancelCallbackUrl" , getCancelCallbackUrl());
        jsapiMap.put("paySign" , paySign);
        jsapiMap.put("packageStr" , packageStr);
        jsapiMap.put("signType" , signType);
        jsapiMap.put("timeStamp" , getTimeStamp()+"");
        return jsapiMap;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
