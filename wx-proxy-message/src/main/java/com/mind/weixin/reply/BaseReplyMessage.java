package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

/**
 * only by generate xml
 * Created by serv on 2014/8/5.
 */
@JacksonXmlRootElement(localName = "xml")
public class BaseReplyMessage implements MessageTypeInitialize,Serializable {
    @JacksonXmlProperty(localName = "ToUserName")
    protected String toUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    protected String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    protected long createTime = System.currentTimeMillis();
    @JacksonXmlProperty(localName = "MsgType")
    protected String msgType = initType();

    @Override
    public String initType() {
        return null;
    }

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
}
