package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.Constants;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.net.URLEncoder;

/**
 * Created by serv on 2015/3/20.
 */
public class GetCardTicketCmd extends WxJsonCommand implements Constants {

    private String ticket;

    public GetCardTicketCmd(String cardId, String code, String openId, int expireSeconds, boolean unique) {
        super("getCardTicket");

        StringBuilder sb = new StringBuilder();
        sb.append("\"card_id\":\"").append(cardId).append("\"");
        if(code!=null){
            sb.append(",\"code\":\"").append(code).append("\"");
        }
        if(openId!=null){
            sb.append(",\"openid\":\"").append(openId).append("\"");
        }
        if(expireSeconds!=0){
            expireSeconds = expireSeconds<=60?60:expireSeconds;
            expireSeconds = expireSeconds>=1800?1800:expireSeconds;
            sb.append(",\"expire_seconds\":\"").append(expireSeconds).append("\"");
        }
        if(unique){
            sb.append(",\"is_unique_code\":\"").append("true").append("\"");
        }
        addVariable("cardJson",sb.toString());
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        ticket = jsonNode.path("ticket").asText();
    }

    public String getTicket() {
        return ticket;
    }

    public String getQrcodeUrl(){
        return String.format(SHOW_QRCODE_URL, URLEncoder.encode(ticket));
    }
}
