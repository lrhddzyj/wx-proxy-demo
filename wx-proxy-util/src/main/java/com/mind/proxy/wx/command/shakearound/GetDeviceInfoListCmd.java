package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.DeviceInfo;

import java.util.List;

/**
 * Created by serv on 2015/5/14.
 */
public class GetDeviceInfoListCmd extends WxJsonCommand {

    private List<DeviceInfo> deviceInfos;

    private int totalCount;

    public GetDeviceInfoListCmd(int begin,int count) {
        super("getDeviceInfoList");
        addVariable("begin", String.valueOf(begin));
        addVariable("count",String.valueOf(count));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        DeviceInfo[] deviceInfos = JsonUtils.json2Array(jsonNode.path("data").path("devices").toString(), DeviceInfo.class);
        this.deviceInfos = Lists.newArrayList(deviceInfos);
        totalCount = jsonNode.path("data").path("total_count").asInt();
    }

    public List<DeviceInfo> getDeviceInfos() {
        return deviceInfos;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
