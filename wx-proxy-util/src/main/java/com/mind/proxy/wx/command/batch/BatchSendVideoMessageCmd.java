package com.mind.proxy.wx.command.batch;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.util.List;

/**
 * Created by serv on 2015/3/19.
 */
public class BatchSendVideoMessageCmd extends WxJsonCommand {

    private Long msgId;

    public BatchSendVideoMessageCmd(String videoId) {
        super("batchSendVideo");
        addVariable("isToAll",Boolean.TRUE.toString());
        addVariable("groupId","0");
        addVariable("videoId",videoId);
    }
    public BatchSendVideoMessageCmd(Integer groupId,String videoId) {
        super("batchSendVideo");
        addVariable("isToAll",Boolean.FALSE.toString());
        addVariable("groupId", groupId.toString());
        addVariable("videoId",videoId);
    }

    public BatchSendVideoMessageCmd(List<String> users, String title, String description, String videoId) {
        super("sendVideoToUsers");
//        addVariable("thumbMediaId",thumbMediaId);
        addVariable("users", JsonUtils.object2Json(users));
        addVariable("title",title);
        addVariable("description",description);
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
