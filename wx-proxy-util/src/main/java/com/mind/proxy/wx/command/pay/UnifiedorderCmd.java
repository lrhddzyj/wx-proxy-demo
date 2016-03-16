package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.UnifiedorderRequest;
import com.mind.wxpay.response.UnifiedorderResponse;

/**
 * Created by serv on 2015/3/19.
 */
public class UnifiedorderCmd extends WxXmlCommand<UnifiedorderResponse> {


    public UnifiedorderCmd(UnifiedorderRequest request, String key) {
        super("unifiedorder", request, key);
    }

}
