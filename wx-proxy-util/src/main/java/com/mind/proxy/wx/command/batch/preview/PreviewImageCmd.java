package com.mind.proxy.wx.command.batch.preview;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class PreviewImageCmd extends WxJsonCommand {

    private Long msgId;

    public PreviewImageCmd(String openId, String mediaId) {
        super("previewImage");
        addVariable("openId",openId);
        addVariable("mediaId",mediaId);
    }


    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgId = jsonNode.path("msg_id").asLong();
    }

    public Long getMsgId() {
        return msgId;
    }

}
