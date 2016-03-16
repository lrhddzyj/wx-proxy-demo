package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class CreateCardCmd extends WxJsonCommand {

    private String cardId;

    public CreateCardCmd(String cardJson) {
        super("createCard");
        addVariable("cardJson",cardJson);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        cardId = jsonNode.path("card_id").asText();
    }

    public String getCardId() {
        return cardId;
    }
}
