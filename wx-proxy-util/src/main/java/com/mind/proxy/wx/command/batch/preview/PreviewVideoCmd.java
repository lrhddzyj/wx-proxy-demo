package com.mind.proxy.wx.command.batch.preview;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/19.
 */
public class PreviewVideoCmd extends WxJsonCommand {

    private Long msgId;

    public PreviewVideoCmd(String openId, String videoId) {
        super("previewVideo");
        addVariable("openId", openId);
        addVariable("videoId",videoId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgId = jsonNode.path("msg_id").asLong();
    }

    public Long getMsgId() {
        return msgId;
    }
}
