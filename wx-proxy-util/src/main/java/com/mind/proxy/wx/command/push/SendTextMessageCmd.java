package com.mind.proxy.wx.command.push;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class SendTextMessageCmd extends WxJsonCommand {

    public SendTextMessageCmd(String openId,String content) {
        super("sendTextMessage");
        addVariable("openId",openId);
        addVariable("content",content);
    }

}
