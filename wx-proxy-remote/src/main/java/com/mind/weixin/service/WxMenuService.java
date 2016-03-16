package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Menu;

import java.util.List;

/**
 * Created by serv on 2014/7/26.
 */
public interface WxMenuService {
    /**
     * 创建菜单
     * @param wxAppId 微信公众号appId
     * @param menus 菜单list
     * @return 0表示成功
     */
    public Boolean createMenu(String wxAppId, List<Menu> menus) throws WeiXinException;

    /**
     * 获取服务号下的菜单
     * @param wxAppId 微信公众号appId
     * @return 菜单list
     */
    public List<Menu> getMenus(String wxAppId) throws WeiXinException;

    /**
     * 删除菜单
     * @param wxAppId 微信公众号appId
     * @return 0代表成功
     */
    public Boolean deleteMenus(String wxAppId) throws WeiXinException ;
}
