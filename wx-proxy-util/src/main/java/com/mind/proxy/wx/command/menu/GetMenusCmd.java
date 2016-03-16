package com.mind.proxy.wx.command.menu;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Menu;

import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class GetMenusCmd extends WxJsonCommand {

    private List<Menu> menus;

    public GetMenusCmd() {
        super("getMenus");
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        menus = JsonUtils.json2List(jsonNode.path("menu").path("button").toString(), Menu.class);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
