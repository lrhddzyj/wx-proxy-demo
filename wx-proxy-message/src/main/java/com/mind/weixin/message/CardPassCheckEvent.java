package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;


/**
 * Created by serv on 2015/1/31.
 */
public class CardPassCheckEvent extends BaseEventMessage {
    @JacksonXmlProperty(localName = "CardId")
    protected String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
