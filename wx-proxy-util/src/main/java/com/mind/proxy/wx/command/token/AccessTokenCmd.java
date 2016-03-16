package com.mind.proxy.wx.command.token;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;

/**
 * Created by serv on 2015/3/16.
 */
public class AccessTokenCmd extends WxJsonCommand {

    private String accessToken;

    public AccessTokenCmd(String appId, String secret) {
        super("accessTokenUrl");
        addVariable("appId", appId);
        addVariable("secret", secret);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        String errCode = jsonNode.path("errcode").asText();
        if (errCode==null||"".equals(errCode)){
            accessToken = jsonNode.path("access_token").asText();
        }else{
            throw new WeiXinException(90006,"获取token失败");
        }
    }

    public String getAccessToken() {
        return accessToken;
    }
}
