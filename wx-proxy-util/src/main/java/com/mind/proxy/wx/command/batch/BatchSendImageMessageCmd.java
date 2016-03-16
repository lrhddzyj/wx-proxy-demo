package com.mind.proxy.wx.command.batch;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.util.List;

/**
 * Created by serv on 2015/3/19.
 */
public class BatchSendImageMessageCmd extends WxJsonCommand {


    private Long msgId;

    public BatchSendImageMessageCmd(String mediaId) {
        super("batchSendImage");
        addVariable("isToAll",Boolean.TRUE.toString());
        addVariable("groupId","0");
        addVariable("mediaId",mediaId);
    }
    public BatchSendImageMessageCmd(Integer groupId, String mediaId) {
        super("batchSendImage");
        addVariable("isToAll",Boolean.FALSE.toString());
        addVariable("groupId",groupId.toString());
        addVariable("mediaId",mediaId);
    }
    public BatchSendImageMessageCmd(List<String> users, String mediaId) {
        super("sendImageToUsers");
        addVariable("users", JsonUtils.object2Json(users));
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
