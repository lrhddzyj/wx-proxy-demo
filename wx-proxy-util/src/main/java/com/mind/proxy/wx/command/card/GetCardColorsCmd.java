package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/7/13.
 */
public class GetCardColorsCmd extends WxJsonCommand {

    private String retMsg ;

    public GetCardColorsCmd() {
        super("getCardColors");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        retMsg = resultText ;
    }

    public String getRetMsg() {
        return retMsg;
    }
}
