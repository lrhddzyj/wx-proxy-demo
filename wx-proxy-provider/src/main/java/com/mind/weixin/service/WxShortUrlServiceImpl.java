package com.mind.weixin.service;

import com.mind.proxy.wx.command.url.GetUrlByTicketCmd;
import com.mind.proxy.wx.command.url.Long2ShortCmd;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2014/9/1.
 */
@Service
public class WxShortUrlServiceImpl extends BaseService implements WxShortUrlService {

    @Override
    public String long2Short(String wxAppId, String longUrl) {
        return execToken(wxAppId,new Long2ShortCmd(longUrl)).getShortUrl();
    }

    @Override
    public String getUrlByTicket(String wxAppId, String ticket) {
        return execToken(wxAppId,new GetUrlByTicketCmd(ticket)).getShortUrl();
    }
}
