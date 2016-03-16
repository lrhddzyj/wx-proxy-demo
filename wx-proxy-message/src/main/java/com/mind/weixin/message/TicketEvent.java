package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;

/**
 * Created by serv on 2014/8/1.
 */
public class TicketEvent extends BaseEventMessage {
    @JacksonXmlProperty(localName = "EventKey")
    protected String eventKey;
    @JacksonXmlProperty(localName = "Ticket")
    protected String ticket;

    protected boolean isFirstSubscribe;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public boolean getIsFirstSubscribe() {
        return isFirstSubscribe;
    }

    public void setIsFirstSubscribe(boolean isFirstSubscribe) {
        this.isFirstSubscribe = isFirstSubscribe;
    }
}
