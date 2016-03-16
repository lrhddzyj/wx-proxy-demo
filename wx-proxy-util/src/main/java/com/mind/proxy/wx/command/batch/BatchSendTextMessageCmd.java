package com.mind.proxy.wx.command.batch;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.util.List;

/**
 * Created by serv on 2015/3/19.
 */
public class BatchSendTextMessageCmd extends WxJsonCommand{

    private Long msgId;

    public BatchSendTextMessageCmd(String content) {
        super("batchSendText");
        addVariable("isToAll",Boolean.TRUE.toString());
        addVariable("groupId","0");
        addVariable("content",content);
    }
    public BatchSendTextMessageCmd(Integer groupId, String content) {
        super("batchSendText");
        addVariable("isToAll",Boolean.FALSE.toString());
        addVariable("groupId",groupId.toString());
        addVariable("content",content);
    }

    public BatchSendTextMessageCmd(List<String> users, String newsId) {
        super("sendTextToUsers");
        addVariable("users", JsonUtils.object2Json(users));
        addVariable("content",newsId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        msgId = jsonNode.path("msg_id").asLong();
    }

    public Long getMsgId() {
        return msgId;
    }

}
