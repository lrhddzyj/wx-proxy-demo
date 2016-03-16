package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.UserInfo;

/**
 * Created by serv on 2014/11/24.
 */
public interface WxUserInfoRecordService  {

    /**
     * 根据用户的openId 获取用户基本信息
     * @param appId 公众号appId
     * @param openId 用户的openId
     * @return userInfo
     */
    public UserInfo getUserInfo(String appId, String openId) throws WeiXinException;

    /**
     * 根据用户的openId 获取用户基本信息
     * @param userInfo 用户信息
     */
    public void saveUserInfo(UserInfo userInfo) throws WeiXinException;


    /**
     * 更新用户的交互时间
     * @param appId
     * @param openId
     * @param kissTime
     */
    public void updateKissTime(String appId, String openId, String kissTime);


}
