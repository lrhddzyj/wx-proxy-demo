package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/11/20.
 */
public class KfChatInfo implements Serializable {

    /**
     * 客服账号
     */
    @JsonProperty("worker")
    private String worker;

    /**
     * 普通用户openid
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 操作ID（会话状态），具体说明见下文
     */
    @JsonProperty("opercode")
    private String operCode;

    /**
     * 操作时间，UNIX时间戳(秒级别)
     */
    @JsonProperty("time")
    private long time;

    /**
     * 聊天记录
     */
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

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
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
