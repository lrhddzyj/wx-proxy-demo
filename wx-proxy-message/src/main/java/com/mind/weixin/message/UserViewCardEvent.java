package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;

/**
 * Created by serv on 2015/4/10.
 */
public class UserViewCardEvent extends BaseEventMessage{

    @JacksonXmlProperty(localName = "CardId")
    protected String cardId;

    @JacksonXmlProperty(localName = "UserCardCode")
    protected String userCardCode;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }
}
