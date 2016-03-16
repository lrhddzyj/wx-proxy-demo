package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;

/**
 * Created by serv on 2014/9/1.
 */
public interface WxShortUrlService {

    /**
     * 长链接2短链接
     * @param longUrl
     * @return
     */
    public String long2Short(String wxAppId, String longUrl) throws WeiXinException;

    /**
     * 通过ticket 获取短连接
     * @param wxAppId
     * @param ticket
     * @return
     */
    public String getUrlByTicket(String wxAppId, String ticket);
}
