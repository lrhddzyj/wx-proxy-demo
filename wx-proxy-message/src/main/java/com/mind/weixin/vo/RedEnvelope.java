package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/7/29.
 */
public class RedEnvelope implements Serializable{
    /**
     * 红包发送者名称(同send_name)
     */
    @JsonProperty("act_name")
    private String actName;

    /**
     * 资金提供方名称
     */
    @JsonProperty("nick_name")
    private String nickName;

    /**
     * 接受收红包的用户
     * 用户在wxappid下的openid
     */
    @JsonProperty("re_openid")
    private String reOpenid;

    /**
     * 红包发送者名称
     */
    @JsonProperty("send_name")
    private String sendName;


    /**
     * 付款金额
     */
    @JsonProperty("total_amount")
    private long totalAmount;

    /**
     * 红包发放总人数
     */
    @JsonProperty("total_num")
    private int totalNum;

    /**
     * 红包祝福语
     */
    @JsonProperty("wishing")
    private String wishing;

    /**
     * 最大红包金额，单位分
     */
    @JsonProperty("max_value")
    private long maxValue;

    /**
     * 最小红包金额，单位分
     */
    @JsonProperty("min_value")
    private long minValue;

    /**
     * 业务主键-华阳内部的商户唯一字符串,
     */
    @JsonProperty("wxappid")
    private String appId;
    /**
     * 商户号
     */
    @JsonProperty("spid")
    private String spid;

    /**
     * 商户秘钥
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReOpenid() {
        return reOpenid;
    }

    public void setReOpenid(String reOpenid) {
        this.reOpenid = reOpenid;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
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

    public long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    public void setMinValue(long minValue) {
        this.minValue = minValue;
    }

    public String getActName() {
        if(actName==null){
            return sendName;
        }
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }
}
