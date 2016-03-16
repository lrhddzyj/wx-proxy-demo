package com.mind.weixin.service;

import com.mind.proxy.wx.command.menu.CreateMenuCmd;
import com.mind.proxy.wx.command.menu.DeleteMenusCmd;
import com.mind.proxy.wx.command.menu.GetMenusCmd;
import com.mind.weixin.vo.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serv on 2014/7/26.
 */
@Service
public class WxMenuServiceImpl extends BaseService implements WxMenuService {

    @Override
    public Boolean createMenu(String wxAppId, List<Menu> menus) {
        execToken(wxAppId,new CreateMenuCmd(menus));
        return true;
    }

    @Override
    public List<Menu> getMenus(String wxAppId) {
        return execToken(wxAppId,new GetMenusCmd()).getMenus();
    }

    @Override
    public Boolean deleteMenus(String wxAppId) {
        execToken(wxAppId,new DeleteMenusCmd());
        return true;
    }
}
