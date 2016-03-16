package com.mind.proxy.wx.command.poi;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/6/10.
 */
public class DelPoiCmd extends WxJsonCommand {

    private String retMsg ;

    public DelPoiCmd(String poiId) {
        super("delpoi");
        addVariable("poiId", poiId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        retMsg = resultText ;
    }

    public String getRetMsg() {
        return retMsg;
    }
}
