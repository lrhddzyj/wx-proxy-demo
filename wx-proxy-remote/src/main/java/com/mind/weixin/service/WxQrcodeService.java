package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;

import java.util.Map;

/**
 * Created by serv on 2014/7/31.
 */
public interface WxQrcodeService {

    /**
     * 创建永久二维码
     * @param wxAppId 微信公众号appId
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return 当前二维码的ticket和url和data
     */
    public Map<String,String> createQrcodeTicket(String wxAppId, Long sceneId) throws WeiXinException;

    /**
     * 创建临时二维码
     * @param wxAppId 微信公众号appId
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过1800。
     * @return keys: ticket url
     */
    public Map<String,String> createQrcodeTicket(String wxAppId, Long sceneId, Integer expireSeconds) throws WeiXinException;

}
