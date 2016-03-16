package com.mind.proxy.wx.command.oauth2;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class GetWxRedirectUrlCmd extends WxJsonCommand {

    private String redirectUrl;

    public GetWxRedirectUrlCmd(String appId , String url, String scope, String state) {
        super("oauth2Authorize");
        addVariable("appId",appId);
        addVariable("url", url);
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
