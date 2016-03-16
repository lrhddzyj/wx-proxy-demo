package com.mind.proxy.wx.command.batch.preview;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/19.
 */
public class PreviewTextCmd extends WxJsonCommand {

    private Long msgId;

    public PreviewTextCmd(String openId,String content) {
        super("previewText");
        addVariable("openId", openId);
        addVariable("content",content);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgId = jsonNode.path("msg_id").asLong();
    }

    public Long getMsgId() {
        return msgId;
    }
}
