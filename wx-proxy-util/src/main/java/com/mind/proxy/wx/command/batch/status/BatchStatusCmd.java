package com.mind.proxy.wx.command.batch.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class BatchStatusCmd extends WxJsonCommand {

    private String msgStatus;

    public BatchStatusCmd(String msgId) {
        super("getMsgStatus");
        addVariable("msgId",msgId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgStatus = jsonNode.path("msg_status").asText();
    }

    public String getMsgStatus() {
        return msgStatus;
    }
}
