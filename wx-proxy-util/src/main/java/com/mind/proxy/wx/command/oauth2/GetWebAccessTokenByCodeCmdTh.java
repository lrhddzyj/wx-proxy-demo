package com.mind.proxy.wx.command.oauth2;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Oauth2Token;

/**
 * Created by user on 2015/5/8.
 */
public class GetWebAccessTokenByCodeCmdTh extends WxJsonCommand {
    private Oauth2Token token;

    public GetWebAccessTokenByCodeCmdTh(String componentAccessToken, String appId, String code, String componentAppId) {
        super("oauth2WebTokenTh");
        addVariable("componentAccessToken", componentAccessToken);
        addVariable("appId",appId);
        addVariable("code",code);
        addVariable("componentAppId",componentAppId);
    }


    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        token = JsonUtils.json2Object(resultText, Oauth2Token.class);
    }

    public Oauth2Token getToken() {
        return token;
    }
}
