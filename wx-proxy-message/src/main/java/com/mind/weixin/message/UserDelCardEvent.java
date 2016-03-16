package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2015/1/31.
 */
public class UserDelCardEvent extends CardPassCheckEvent{

    @JacksonXmlProperty(localName = "UserCardCode")
    protected String userCardCode;


    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }
}
