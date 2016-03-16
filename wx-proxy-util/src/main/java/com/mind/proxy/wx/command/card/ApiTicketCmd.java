package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/5/27.
 */
public class ApiTicketCmd extends WxJsonCommand {

    private String ticket;

    public ApiTicketCmd() {
        super("wx_card_ticket");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        ticket = jsonNode.path("ticket").asText();
    }

    public String getTicket() {
        return ticket;
    }
}
