package com.mind.proxy.wx.command.group;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class UserChangeGroup extends WxJsonCommand {

    public UserChangeGroup(String openId,int groupId) {
        super("userChangeGroup");
        addVariable("openId",openId);
        addVariable("groupId",String.valueOf(groupId));
    }

}
