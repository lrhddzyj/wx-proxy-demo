package com.mind.proxy.wx.command.kf;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.KfOnlineInfo;

import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class GetOnlineKfListCmd extends WxJsonCommand {

    private List<KfOnlineInfo> onlineInfos;

    public GetOnlineKfListCmd() {
        super("getOnlineKfList");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        onlineInfos = JsonUtils.json2List(jsonNode.path("kf_online_list").toString(), KfOnlineInfo.class);
    }

    public List<KfOnlineInfo> getOnlineInfos() {
        return onlineInfos;
    }
}
