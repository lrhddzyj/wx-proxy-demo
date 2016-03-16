package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.CloseOrderRequest;
import com.mind.wxpay.response.CloseOrderResponse;

/**
 * Created by serv on 2015/3/20.
 */
public class CloseOrderCmd extends WxXmlCommand<CloseOrderResponse> {

    public CloseOrderCmd(CloseOrderRequest request, String key) {
        super("closeorder", request, key);
    }
}
