package com.mind.proxy.wx.command.url;

/**
 * Created by serv on 2015/3/17.
 */
public class GetUrlByTicketCmd extends Long2ShortCmd {

    public GetUrlByTicketCmd(String ticket) {
        super("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket);
    }

}
