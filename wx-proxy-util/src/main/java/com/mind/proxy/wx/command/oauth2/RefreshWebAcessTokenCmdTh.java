package com.mind.proxy.wx.command.oauth2;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Oauth2Token;

/**
 * Created by serv on 2015/3/20.
 */
public class RefreshWebAcessTokenCmdTh extends WxJsonCommand {

    private Oauth2Token token;

    public RefreshWebAcessTokenCmdTh(String componentAccessToken, String refreshToken, String code, String componentAppId) {
        super("oauth2RefreshWebTokenTh");
        addVariable("componentAccessToken", componentAccessToken);
        addVariable("refreshToken", refreshToken);
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
