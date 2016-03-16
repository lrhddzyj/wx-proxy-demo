package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class ConsumeCardCmd extends WxJsonCommand {

    private String cardId;
    private String openId;

    public ConsumeCardCmd(String code, String cardId) {
        super("consumeCard");

        StringBuilder sb = new StringBuilder();
        sb.append("\"code\":\"").append(code).append("\"");
        if(cardId!=null){
            sb.append(",\"card_id\":\"").append(cardId).append("\"");
        }

        addVariable("json",sb.toString());
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        cardId = jsonNode.path("card").path("card_id").asText();
        openId = jsonNode.path("openid").asText();
    }

    public String getCardId() {
        return cardId;
    }

    public String getOpenId() {
        return openId;
    }
}
