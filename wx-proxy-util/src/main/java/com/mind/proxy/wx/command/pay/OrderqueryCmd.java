package com.mind.proxy.wx.command.pay;

import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.OrderQueryRequest;
import com.mind.wxpay.response.OrderQueryResponse;

/**
 * Created by serv on 2015/3/20.
 */
public class OrderqueryCmd extends WxXmlCommand<OrderQueryResponse> {

    public OrderqueryCmd(OrderQueryRequest request, String key) {
        super("orderquery", request, key);
    }

    @Override
    protected void doExecute() throws Exception {
        super.doExecute();
    }
}
