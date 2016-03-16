package com.mind.proxy.wx.command.batch.preview;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class PreviewNewsCmd extends WxJsonCommand {

    private Long msgId;

    public PreviewNewsCmd(String openId,String mediaId) {
        super("previewNews");
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
