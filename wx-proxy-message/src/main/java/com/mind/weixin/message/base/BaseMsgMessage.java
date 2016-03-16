package com.mind.weixin.message.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2014/12/29.
 */
public abstract class BaseMsgMessage extends BaseMessage{
    @JacksonXmlProperty(localName = "MsgId")
    protected long msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

}
