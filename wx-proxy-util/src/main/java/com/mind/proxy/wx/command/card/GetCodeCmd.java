package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/5/27.
 */
public class GetCodeCmd extends WxJsonCommand {

    private String resultJson;

    public GetCodeCmd(String code,String cardId) {
        super("getCode");
        addVariable("code", code);
        addVariable("cardId",cardId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        resultJson = resultText;
    }

    public String getResultJson() {
        return resultJson;
    }
}
