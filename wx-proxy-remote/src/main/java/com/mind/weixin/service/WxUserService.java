package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.OpenIdSet;
import com.mind.weixin.vo.UserInfo;

/**
 * Created by serv on 2014/7/26.
 */
public interface WxUserService {
    /**
     * 通过微信的openId获取用户信息
     * @param wxAppId 微信公众号appId
     * @param openId 微信的openId
     * @return 用户详细信息
     */
    public UserInfo userInfoByOpenId(String wxAppId, String openId) throws WeiXinException;


//    /**
//     * 获取所有的关注者列表
//     * @param wxAppId 微信公众号appId
//     * @return 关注者列表
//     */
//    public Set<String> getAttentionOpenIds(String wxAppId) throws WeiXinException;

    /**
     * 获取关注者列表,根据最后一个openid开始
     * @param wxAppId 微信公众号appId
     * @param openId 最后一个openId
     * @return 关注者列表对象
     */
    public OpenIdSet getAttentionOpenIds(String wxAppId, String openId) throws WeiXinException;

    /**
     * 设置用户的备注名
     * @param wxAppId 微信公众号appId
     * @param openId 用户的openId
     * @param remark 备注
     * @return
     */
    public Boolean updateRemark(String wxAppId, String openId, String remark) throws WeiXinException;
}
