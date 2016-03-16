package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.RefundQueryRequest;
import com.mind.wxpay.response.RefundQueryResponse;

/**
 * Created by serv on 2015/3/20.
 */
public class RefundQueryCmd extends WxXmlCommand<RefundQueryResponse> {

    public RefundQueryCmd(RefundQueryRequest request, String key) {
        super("refundquery", request, key);
    }
}
