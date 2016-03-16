package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;

/**
 * Created by serv on 2014/11/21.
 */
public class StatusEvent extends BaseEventMessage {
    @JacksonXmlProperty(localName = "Status")
    private String status;

    @JacksonXmlProperty(localName = "MsgId")
    protected long msgId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
