package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.card.UserCardList;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by user on 2015/7/1.
 */
public class GetUserCardListCmd extends WxJsonCommand {

    private UserCardList cardList ;

    /**
     * 获取用户已领取的券
     * @param openId
     * @param cardId
     */
    public GetUserCardListCmd(String openId,String cardId) {
        super("getUserCardList");

        StringBuffer json =  new StringBuffer("\"openid\":\""+openId+"\" ") ;
        if(StringUtils.isNotEmpty(cardId)){
            json.append(",\"card_id\":\""+cardId+"\"") ;
        }
        addVariable("json",json.toString());
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        cardList = JsonUtils.json2Object(resultText,UserCardList.class);
    }

    public UserCardList getCardList() {
        return cardList;
    }
}
