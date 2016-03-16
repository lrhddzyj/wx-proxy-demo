package com.mind.weixin.service;

import com.mind.httpclient.command.Executors;
import com.mind.proxy.wx.command.oauth2.*;
import com.mind.weixin.vo.Oauth2Token;
import com.mind.weixin.vo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2014/11/24.
 */
@Service
public class WxOauth2ServiceImpl extends BaseService implements WxOauth2Service{

    @Override
    public String getWxRedirectUrl(String appId, String url, String scope, String state) {
        return exec(new GetWxRedirectUrlCmd(appId,url,scope,state)).getRedirectUrl();
    }

    @Override
    public Oauth2Token getWebAccessTokenByCode(String appId, String appSecret, String code) {
        return exec(new GetWebAccessTokenByCodeCmd(appId,appSecret,code)).getToken();
    }

    @Override
    public Oauth2Token refreshWebAcessToken(String appId, String refreshToken) {
        return exec(new RefreshWebAcessTokenCmd(appId,refreshToken)).getToken();
    }

    @Override
    public UserInfo getUserInfo(String webAccessToken, String openId) {
        return exec(new GetWebUserInfoCmd(webAccessToken, openId)).getUserInfo();
    }


    @Override
    public String getWxRedirectUrlTh(String componentAppId,String appId,String redirectUri,String scope,String state) {
        return Executors.build().exec(new AuthorizeCmdTh(componentAppId,appId,redirectUri,scope,state)).getRedirectUrl();
    }

    @Override
    public Oauth2Token getWebAccessTokenByCodeTh(String componentAccessToken,String appId, String code,String componentAppId) {
        return Executors.build().exec(new GetWebAccessTokenByCodeCmdTh(componentAccessToken,appId,code,componentAppId)).getToken();
    }

    @Override
    public Oauth2Token refreshWebAcessTokenTh(String componentAccessToken, String refreshToken,String code,String componentAppId) {
        return Executors.build().exec(new RefreshWebAcessTokenCmdTh(componentAccessToken,refreshToken,code,componentAppId)).getToken();
    }

    @Override
    public UserInfo getUserInfoTh(String webAccessToken, String openId) {
        return Executors.build().exec(new GetWebUserInfoCmdTh(webAccessToken,openId)).getUserInfo();
    }


}
