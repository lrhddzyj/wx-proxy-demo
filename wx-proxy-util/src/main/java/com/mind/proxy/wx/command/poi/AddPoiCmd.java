package com.mind.proxy.wx.command.poi;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.poi.PoiBaseInfo;

/**
 * Created by user on 2015/6/10.
 */
public class AddPoiCmd extends WxJsonCommand {

    private String retMsg ;

    public AddPoiCmd(PoiBaseInfo poiBaseInfo) {
        super("addpoi");
        addVariable("json", JsonUtils.object2Json(poiBaseInfo));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        retMsg = resultText ;
    }

    public String getRetMsg() {
        return retMsg;
    }
}
