package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Group;

import java.util.List;

/**
 * Created by serv on 2014/7/26.
 */
public interface WxGroupService {

    /**
     * 创建分组
     * @param wxAppId 关联主键
     * @param groupName 组名
     * @return 组
     */
    public Group createGroup(String wxAppId, String groupName) throws WeiXinException;

    /**
     * 查询某个服务号或订阅号下所有组的情况
     * @param wxAppId 关联主键
     * @return json格式
     */
    public List<Group> searchAllGroups(String wxAppId) throws WeiXinException;

    /**
     * 通过openId获取当前人所在的组
     * @param wxAppId 微信公众号appId
     * @param openId 微信的openId
     * @return 返回组的ID
     */
    public Integer findOwnerGroupId(String wxAppId, String openId) throws WeiXinException;

    /**
     * 修改组名
     * @param wxAppId 微信公众号appId
     * @param groupId 组ID
     * @param groupName 组名称
     * @return 修改成功true false失败
     */
    public Boolean modifyGroupName(String wxAppId, Integer groupId, String groupName) throws WeiXinException;

    /**
     * 移动用户到另外一个组中
     * @param wxAppId 微信公众号appId
     * @param groupId 目标组ID
     * @param openId 微信的openId
     * @return 修改成功true false失败
     */
    public Boolean userChangeGroup(String wxAppId, Integer groupId, String openId) throws WeiXinException ;

}
