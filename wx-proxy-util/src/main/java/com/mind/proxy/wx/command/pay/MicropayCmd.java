package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.MicropayRequest;
import com.mind.wxpay.response.MicropayResponse;

/**
 * Created by serv on 2015/3/20.
 */
public class MicropayCmd extends WxXmlCommand<MicropayResponse> {

    public MicropayCmd(MicropayRequest request, String key) {
        super("micropay", request, key);
    }
}
