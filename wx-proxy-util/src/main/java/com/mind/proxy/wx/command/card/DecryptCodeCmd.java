package com.mind.proxy.wx.command.card;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class DecryptCodeCmd extends WxJsonCommand {

    private String code;

    public DecryptCodeCmd(String encryptCode) {
        super("decryptCode");
        addVariable("encryptCode",encryptCode);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        code = jsonNode.path("code").asText();
    }

    public String getCode() {
        return code;
    }
}
