package com.mind.weixin.vo.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by user on 2015/7/1.
 */
public class UserCard implements Serializable {

    @JsonProperty("code")
    private String code ;

    @JsonProperty("card_id")
    private String cardId ;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
