package com.mind.proxy.wx.command.poi;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.poi.PoiInfo;

/**
 * Created by user on 2015/6/10.
 */
public class GetPoiCmd extends WxJsonCommand {

    private PoiInfo poiInfo;

    public GetPoiCmd(String poiId) {
        super("getpoi");
        addVariable("poiId", poiId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        poiInfo = JsonUtils.json2Object(jsonNode.path("business").asText(), PoiInfo.class);
    }

    public PoiInfo getPoiInfo() {
        return poiInfo;
    }
}
