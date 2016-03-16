package com.mind.proxy.wx.command.shakearound;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/5/15.
 */
public class DeletePageCmd extends WxJsonCommand {

    public DeletePageCmd(Integer[] pageIds) {
        super("deletePage");
        addVariable("pageIds", JsonUtils.object2Json(pageIds));
    }
}
