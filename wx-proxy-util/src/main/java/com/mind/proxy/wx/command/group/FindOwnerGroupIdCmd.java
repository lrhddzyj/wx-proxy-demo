package com.mind.proxy.wx.command.group;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class FindOwnerGroupIdCmd extends WxJsonCommand {

    private Integer groupId;

    public FindOwnerGroupIdCmd(String openId) {
        super("findOwnerGroupId");
        addVariable("openId",openId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        groupId = jsonNode.path("groupid").asInt();
    }

    public Integer getGroupId() {
        return groupId;
    }
}
