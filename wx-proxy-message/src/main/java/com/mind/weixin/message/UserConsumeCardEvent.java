package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2015/1/31.
 */
public class UserConsumeCardEvent extends CardPassCheckEvent{

    @JacksonXmlProperty(localName = "UserCardCode")
    protected String userCardCode;
    @JacksonXmlProperty(localName = "ConsumeSource")
    protected String consumeSource;


    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public String getConsumeSource() {
        return consumeSource;
    }

    public void setConsumeSource(String consumeSource) {
        this.consumeSource = consumeSource;
    }
}
