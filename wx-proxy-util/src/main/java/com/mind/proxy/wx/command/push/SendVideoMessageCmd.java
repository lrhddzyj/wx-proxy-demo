package com.mind.proxy.wx.command.push;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class SendVideoMessageCmd extends WxJsonCommand {

    public SendVideoMessageCmd(String openId,String mediaId,String title,String description) {
        super("sendVideoMessage");
        addVariable("openId", openId);
        addVariable("mediaId", mediaId);
        addVariable("title", title);
        addVariable("description",description);
    }
}
