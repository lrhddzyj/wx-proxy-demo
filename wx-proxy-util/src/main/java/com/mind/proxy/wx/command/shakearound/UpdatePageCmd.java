package com.mind.proxy.wx.command.shakearound;

import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.PageInfo;

/**
 * Created by serv on 2015/5/15.
 */
public class UpdatePageCmd extends WxJsonCommand {

    public UpdatePageCmd(PageInfo pageInfo) {
        super("updatePage");
        addVariable("page_id",pageInfo.getPageId());
        addVariable("title",pageInfo.getTitle());
        addVariable("description",pageInfo.getDescription());
        addVariable("page_url",pageInfo.getPageUrl());
        addVariable("comment",pageInfo.getComment());
        addVariable("icon_url",pageInfo.getIconUrl());
    }
}
