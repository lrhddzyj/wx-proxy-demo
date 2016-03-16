package com.mind.weixin.vo.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/7/1.
 */
public class UserCardList implements Serializable {

    @JsonProperty("errcode")
    private String errCode ;

    @JsonProperty("errmsg")
    private String errMsg ;

    @JsonProperty("card_list")
    private List<UserCard> cardList ;


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<UserCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<UserCard> cardList) {
        this.cardList = cardList;
    }
}
