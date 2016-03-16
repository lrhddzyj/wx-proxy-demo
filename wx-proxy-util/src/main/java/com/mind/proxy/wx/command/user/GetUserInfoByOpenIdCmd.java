package com.mind.proxy.wx.command.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.UserInfo;
import org.apache.http.util.Asserts;

/**
 * Created by serv on 2015/3/16.
 */
public class GetUserInfoByOpenIdCmd extends WxJsonCommand {

    private UserInfo userInfo;

    public GetUserInfoByOpenIdCmd(String openId) {
        super("getUserBaseInfo");
        Asserts.notEmpty(openId, "openId");
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
