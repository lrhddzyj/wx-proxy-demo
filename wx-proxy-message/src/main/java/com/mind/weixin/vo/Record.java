package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/8/5.
 */
public class Record implements Serializable {

    @JsonProperty("worker")
    private String worker;
    @JsonProperty("openid")
    private String openId;
    /**
     * 1000	 创建未接入会话
     1001	 接入会话
     1002	 主动发起会话
     1004	 关闭会话
     1005	 抢接会话
     2001	 公众号收到消息
     2002	 客服发送消息
     2003	 客服收到消息
     */
    @JsonProperty("opercode")
    private int operCode;
    @JsonProperty("time")
    private long time;
    @JsonProperty("text")
    private String text;


    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getOperCode() {
        return operCode;
    }

    public void setOperCode(int operCode) {
        this.operCode = operCode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
