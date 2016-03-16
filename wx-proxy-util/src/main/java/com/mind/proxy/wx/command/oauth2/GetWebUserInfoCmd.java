package com.mind.proxy.wx.command.oauth2;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.UserInfo;

/**
 * Created by serv on 2015/3/20.
 */
public class GetWebUserInfoCmd extends WxJsonCommand {

    private UserInfo userInfo;

    public GetWebUserInfoCmd(String webAccessToken, String openId) {
        super("snsWebUserInfo");
        addVariable("webAccessToken", webAccessToken);
        addVariable("openId",openId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        userInfo = JsonUtils.json2Object(resultText,UserInfo.class);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
