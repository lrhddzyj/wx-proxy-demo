package com.mind.proxy.wx.command.push;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class SendImageMessageCmd extends WxJsonCommand {

    public SendImageMessageCmd(String openId,String mediaId) {
        super("sendImageMessage");
        addVariable("openId",openId);
        addVariable("mediaId",mediaId);
    }

}
