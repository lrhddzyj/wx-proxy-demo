package com.mind.weixin.message.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/7/23.
 */
public abstract class BaseMessage implements Serializable {
    protected String appId;
    @JacksonXmlProperty(localName = "ToUserName")
    protected String toUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    protected String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    protected long createTime;
    @JacksonXmlProperty(localName = "MsgType")
    protected String msgType = initType();

    protected abstract String initType();

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
