package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.card.CardBulletin;

/**
 * Created by user on 2015/6/10.
 */
public class SendCardBulletinCmd extends WxJsonCommand {

    private String resultText ;

    public SendCardBulletinCmd(CardBulletin info) {
        super("sendCardBulletin");
        addVariable("json", JsonUtils.object2Json(info));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        this.resultText = resultText ;
    }

    public String getResultText() {
        return resultText;
    }
}