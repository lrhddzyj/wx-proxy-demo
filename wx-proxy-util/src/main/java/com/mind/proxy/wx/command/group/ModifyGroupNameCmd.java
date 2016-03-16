package com.mind.proxy.wx.command.group;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class ModifyGroupNameCmd extends WxJsonCommand {

    public ModifyGroupNameCmd(int groupId,String groupName) {
        super("modifyGroupName");
        addVariable("groupId",String.valueOf(groupId));
        addVariable("groupName",groupName);
    }

}
