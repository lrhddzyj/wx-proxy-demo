package com.mind.proxy.wx.command.pay;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.BillQueryRequest;

/**
 * Created by serv on 2015/3/20.
 */
public class DownloadbillCmd extends WxXmlCommand<String> {

    private String result;

    public DownloadbillCmd(BillQueryRequest request, String key) {
        super("downloadbill", request, key);
    }

    @Override
    protected JsonNode wrap2JsonNode(String resultText) {
        return null;
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        result = resultText;
    }

    @Override
    public String getResponse() {
        return result;
    }
}
