package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.PageInfo;

import java.util.List;

/**
 * Created by serv on 2015/5/15.
 */
public class SearchPageCmd extends WxJsonCommand {

    private Integer totalCount;
    private List<PageInfo> pageInfos;

    public SearchPageCmd(Integer[] pageIds) {
        super("searchPage1");
        addVariable("pageIds", JsonUtils.object2Json(pageIds));
    }
    public SearchPageCmd(int begin,int count) {
        super("searchPage2");
        addVariable("begin", String.valueOf(begin));
        addVariable("count",String.valueOf(count));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        totalCount = jsonNode.path("data").path("total_count").asInt();
        pageInfos = JsonUtils.json2List(jsonNode.path("data").path("pages").toString(),PageInfo.class);
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<PageInfo> getPageInfos() {
        return pageInfos;
    }
}
