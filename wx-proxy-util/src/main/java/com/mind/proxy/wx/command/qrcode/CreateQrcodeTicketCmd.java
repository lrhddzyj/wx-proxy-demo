package com.mind.proxy.wx.command.qrcode;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.Constants;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.net.URLEncoder;

/**
 * Created by serv on 2015/3/20.
 */
public class CreateQrcodeTicketCmd extends WxJsonCommand implements Constants{

    private String ticket;
    private String data;

    public CreateQrcodeTicketCmd(Long sceneId,Integer expire) {
        super("createExpireQrcodeTicket");
        addVariable("expire",expire.toString());
        addVariable("sceneId",sceneId.toString());
    }
    public CreateQrcodeTicketCmd(Long sceneId) {
        super("createQrcodeTicket");
        addVariable("sceneId",sceneId.toString());
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        ticket = jsonNode.path("ticket").asText();
        data = jsonNode.path("url").asText();
    }

    public String getTicket() {
        return ticket;
    }

    public String getData() {
        return data;
    }

    public String getQrcodeUrl(){
        return String.format(SHOW_QRCODE_URL, URLEncoder.encode(ticket));
    }
}
