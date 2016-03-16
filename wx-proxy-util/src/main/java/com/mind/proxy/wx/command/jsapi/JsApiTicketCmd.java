package com.mind.proxy.wx.command.jsapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class JsApiTicketCmd extends WxJsonCommand {

    private String ticket;

    public JsApiTicketCmd() {
        super("getJsapiTicket");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        ticket = jsonNode.path("ticket").asText();
    }

    public String getTicket() {
        return ticket;
    }
}
