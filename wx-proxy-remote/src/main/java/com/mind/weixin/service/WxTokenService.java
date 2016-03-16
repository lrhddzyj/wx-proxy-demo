package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;

/**
 * Created by serv on 2014/11/27.
 */
public interface WxTokenService{
    /**
     * 通过appId获取token,如果已有有效的token则直接返回,否则创建并返回
     * @param appId
     * @return
     */
    public String getToken(String appId) throws WeiXinException;

    /**
     * 创建一个新的token,并返回
     * @param appId
     * @return
     */
    public String buildToken(String appId) throws WeiXinException;
}
