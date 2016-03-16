package com.mind.proxy.wx.command.poi;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.poi.PoiPageInfo;

/**
 * Created by user on 2015/6/10.
 */
public class GetPoiListCmd extends WxJsonCommand {

    private PoiPageInfo poiPageInfo;

    public GetPoiListCmd(String begin,String limit) {
        super("getpoilist");
        addVariable("begin", begin);
        addVariable("limit", limit);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        poiPageInfo = JsonUtils.json2Object(resultText,PoiPageInfo.class);
    }

    public PoiPageInfo getPoiPageInfo() {
        return poiPageInfo;
    }
}
