package com.mind.proxy.wx.command.kf;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.KfBaseInfo;

import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class GetKfListCmd extends WxJsonCommand {

    private List<KfBaseInfo> infoList;

    public GetKfListCmd() {
        super("getKfList");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        infoList = JsonUtils.json2List(jsonNode.path("kf_list").toString(), KfBaseInfo.class);
    }

    public List<KfBaseInfo> getInfoList() {
        return infoList;
    }
}
