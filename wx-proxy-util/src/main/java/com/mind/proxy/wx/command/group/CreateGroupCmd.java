package com.mind.proxy.wx.command.group;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Group;

/**
 * Created by serv on 2015/3/18.
 */
public class CreateGroupCmd extends WxJsonCommand {

    private Group group;

    public CreateGroupCmd(String groupName) {
        super("createGroup");
        if (groupName==null||groupName.equals("") || groupName.length() > 30){
            throw new WeiXinException(90001,"组名不能为空并且组名不能超过30个字符！" , new IllegalAccessError("创建组失败！"));
        }
        addVariable("groupName",groupName);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        group = JsonUtils.json2Object(jsonNode.path("group").toString(), Group.class);
    }

    public Group getGroup() {
        return group;
    }
}
