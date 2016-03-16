package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.PageInfo;

/**
 * Created by serv on 2015/5/15.
 */
public class AddPageCmd extends WxJsonCommand{

    private int pageId;

    public AddPageCmd(PageInfo pageInfo) {
        super("addPage");
        addVariable("title", pageInfo.getTitle());
        addVariable("description",pageInfo.getDescription());
        addVariable("pageUrl",pageInfo.getPageUrl());
        addVariable("comment",pageInfo.getComment());
        addVariable("iconUrl",pageInfo.getIconUrl());
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        pageId = jsonNode.path("data").path("page_id").asInt();
    }

    public int getPageId() {
        return pageId;
    }
}
