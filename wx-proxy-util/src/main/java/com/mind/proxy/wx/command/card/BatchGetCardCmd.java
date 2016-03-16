package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.card.CardList;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by user on 2015/7/1.
 */
public class BatchGetCardCmd extends WxJsonCommand {

    private CardList cardList ;

    public BatchGetCardCmd(String offset,String count,String ... statusList) {
        super("batchGetCard");
        addVariable("offset", offset);
        addVariable("count", count);

        String joinStr = StringUtils.join(statusList, ",");
        addVariable("statusList", joinStr);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        cardList = JsonUtils.json2Object(resultText, CardList.class);
    }

    public CardList getCardList() {
        return cardList;
    }
}

