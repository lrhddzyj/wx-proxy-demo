package com.mind.weixin.vo.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/7/1.
 */
public class CardList implements Serializable {

    /**
     * 错误码，0为正常。
     */
    @JsonProperty("errcode")
    private String errCode ;

    /**
     * 错误信息。
     */
    @JsonProperty("errmsg")
    private String errMsg ;

    /**
     * 卡券ID列表。
     */
    @JsonProperty("card_id_list")
    private List<String> cardIdList ;

    /**
     * 该商户名下卡券ID总数。
     */
    @JsonProperty("total_num")
    private String totalNum ;

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

    public List<String> getCardIdList() {
        return cardIdList;
    }

    public void setCardIdList(List<String> cardIdList) {
        this.cardIdList = cardIdList;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }
}
