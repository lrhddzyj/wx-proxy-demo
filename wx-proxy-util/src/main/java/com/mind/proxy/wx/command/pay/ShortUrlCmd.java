package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.ShortUrlRequest;
import com.mind.wxpay.response.ShortUrlResponse;

/**
 * Created by serv on 2015/3/20.
 */
public class ShortUrlCmd extends WxXmlCommand<ShortUrlResponse> {

    public ShortUrlCmd(ShortUrlRequest request, String key) {
        super("shorturl", request, key);
    }
}
