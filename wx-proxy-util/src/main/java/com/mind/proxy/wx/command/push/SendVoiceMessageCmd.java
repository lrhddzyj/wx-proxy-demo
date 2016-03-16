package com.mind.proxy.wx.command.push;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class SendVoiceMessageCmd extends WxJsonCommand {

    public SendVoiceMessageCmd(String openId,String mediaId) {
        super("sendVoiceMessage");
        addVariable("openId",openId);
        addVariable("mediaId",mediaId);
    }

}
