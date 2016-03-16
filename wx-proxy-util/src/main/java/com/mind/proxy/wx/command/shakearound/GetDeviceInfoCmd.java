package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.DeviceInfo;

/**
 * Created by serv on 2015/5/14.
 */
public class GetDeviceInfoCmd extends WxJsonCommand {

    private DeviceInfo deviceInfo;

    public GetDeviceInfoCmd(String deviceId) {
        super("getDeviceInfo");
        addVariable("deviceId",deviceId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        DeviceInfo[] deviceInfos = JsonUtils.json2Array(jsonNode.path("data").path("devices").toString(), DeviceInfo.class);
        deviceInfo = deviceInfos[0];
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }
}
