package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.DeviceApplyId;

/**
 * Created by serv on 2015/5/14.
 */
public class ApplyDeviceCmd extends WxJsonCommand {

    private DeviceApplyId applyId;

    public ApplyDeviceCmd(int quantity,String applyReason,String comment,int poiId) {
        super("applyIdDevice");
        addVariable("quantity", String.valueOf(quantity));
        addVariable("applyReason",applyReason);
        addVariable("comment",comment);
        addVariable("poiId", String.valueOf(poiId));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        applyId = JsonUtils.json2Object(jsonNode.path("data").toString(),DeviceApplyId.class);
    }

    public DeviceApplyId getApplyId() {
        return applyId;
    }
}
