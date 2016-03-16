package com.mind.proxy.wx.command.push;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Music;

/**
 * Created by serv on 2015/3/18.
 */
public class SendMusicMessageCmd extends WxJsonCommand {

    public SendMusicMessageCmd(String openId,Music music) {
        super("sendMusicMessage");
        addVariable("openId",openId);
        addVariable("music", JsonUtils.object2Json(music));
    }
}
