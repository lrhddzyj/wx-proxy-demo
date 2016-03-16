package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class GetCardDetailCmd extends WxJsonCommand {

    private String cardJson;

    public GetCardDetailCmd(String cardId) {
        super("getCardDetail");
        addVariable("cardId",cardId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        cardJson = jsonNode.path("card").toString();
    }

    public String getCardJson() {
        return cardJson;
    }
}
