package com.mind.proxy.wx.command.menu;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Menu;

import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class CreateMenuCmd extends WxJsonCommand {

    public CreateMenuCmd(List<Menu> menus) {
        super("createMenu");
        addVariable("menus", JsonUtils.object2Json(menus));
    }
}
