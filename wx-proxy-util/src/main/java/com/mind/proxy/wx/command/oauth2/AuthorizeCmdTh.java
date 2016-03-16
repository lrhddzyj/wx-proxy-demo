package com.mind.proxy.wx.command.oauth2;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/5/8.
 */
public class AuthorizeCmdTh extends WxJsonCommand {

    private String redirectUrl;

    public AuthorizeCmdTh(String componentAppId, String appId, String redirectUri, String scope, String state) {
        super("oauth2AuthorizeTh");
        addVariable("componentAppId", componentAppId);
        addVariable("appId", appId);
        addVariable("redirectUri", redirectUri);
        addVariable("scope",scope);
        addVariable("state",state);
    }

    @Override
    protected void doExecute() throws Exception {
        redirectUrl = getLocation().getUrl();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
