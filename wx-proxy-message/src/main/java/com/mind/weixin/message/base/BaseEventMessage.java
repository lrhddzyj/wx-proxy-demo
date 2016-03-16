package com.mind.weixin.message.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2014/7/24.
 */
public abstract class BaseEventMessage extends BaseMessage {
    @JacksonXmlProperty(localName = "Event")
    protected String event;//subscribe scan

    @Override
    protected String initType() {
        return "event";
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
