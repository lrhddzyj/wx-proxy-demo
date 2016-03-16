package com.mind.proxy.wx.command.group;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Group;

import java.util.List;

/**
 * Created by serv on 2015/3/18.
 */
public class SearchGroupInfosCmd extends WxJsonCommand {

    private List<Group> groups;

    public SearchGroupInfosCmd() {
        super("searchGroupInfos");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        groups = JsonUtils.json2List(jsonNode.path("groups").toString(), Group.class);
    }

    public List<Group> getGroups() {
        return groups;
    }
}
