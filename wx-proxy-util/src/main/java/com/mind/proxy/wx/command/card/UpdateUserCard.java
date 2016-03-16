package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/4/9.
 */
public class UpdateUserCard extends WxJsonCommand {

    private String result;

    public UpdateUserCard(String json) {
        super("updateuserCard");
        addVariable("json",json);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        result = resultText;
    }

    public String getResult() {
        return result;
    }
}
