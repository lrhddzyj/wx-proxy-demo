package com.mind.proxy.wx.command.batch;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.util.List;

/**
 * Created by serv on 2015/3/19.
 */
public class BatchSendNewsMessageCmd extends WxJsonCommand{

    private Long msgId;

    public BatchSendNewsMessageCmd(String newsId) {
        super("batchSendNews");
        addVariable("isToAll",Boolean.TRUE.toString());
        addVariable("groupId","0");
        addVariable("newsId",newsId);
    }
    public BatchSendNewsMessageCmd(Integer groupId ,String newsId) {
        super("batchSendNews");
        addVariable("isToAll",Boolean.FALSE.toString());
        addVariable("groupId",groupId.toString());
        addVariable("newsId",newsId);
    }

    public BatchSendNewsMessageCmd(List<String> users, String newsId) {
        super("sendNewsToUsers");
        addVariable("users", JsonUtils.object2Json(users));
        addVariable("newsId",newsId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgId = jsonNode.path("msg_id").asLong();
    }

    public Long getMsgId() {
        return msgId;
    }
}
