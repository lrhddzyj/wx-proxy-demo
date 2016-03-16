package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Oauth2Token;
import com.mind.weixin.vo.UserInfo;

/**
 * Created by serv on 2014/11/24.
 */
public interface WxOauth2Service {
    /**
     * 获取wx的redirecturl
     * @param appId wxappId
     * @param url 要转向的url
     * @param scope 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @param state 附加参数
     * @return url
     */
    public String getWxRedirectUrl(String appId, String url, String scope, String state) throws WeiXinException;

    /**
     * 获取微信用户详细信息
     * @param appId 微信appId
     * @param appSecret 公众号的appsecret
     * @param code
     * @return
     */
    public Oauth2Token getWebAccessTokenByCode(String appId, String appSecret, String code) throws WeiXinException;

    /**
     * 刷新网页token
     * @param appId
     * @param refreshToken
     * @return
     */
    public Oauth2Token refreshWebAcessToken(String appId, String refreshToken) throws WeiXinException;

    /**
     * 根据网页token获取用户信息
     * @param webAccessToken 网页token
     * @param openId 用户对应公众号的唯一openId
     * @return 用户信息
     */
    public UserInfo getUserInfo(String webAccessToken, String openId) throws WeiXinException;


    String getWxRedirectUrlTh(String componentAppId, String appId, String redirectUri, String scope, String state);

    Oauth2Token getWebAccessTokenByCodeTh(String componentAccessToken, String appId, String code, String componentAppId);

    Oauth2Token refreshWebAcessTokenTh(String componentAccessToken, String refreshToken, String code, String componentAppId);

    UserInfo getUserInfoTh(String webAccessToken, String openId);
}
