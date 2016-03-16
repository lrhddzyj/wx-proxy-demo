package com.mind.weixin.service;

import com.mind.proxy.wx.command.user.GetAttentionOpenIdsCmd;
import com.mind.proxy.wx.command.user.GetUserInfoByOpenIdCmd;
import com.mind.proxy.wx.command.user.UpdateRemarkCmd;
import com.mind.weixin.vo.OpenIdSet;
import com.mind.weixin.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2014/7/26.
 */
@Service
public class WxUserServiceImpl extends BaseService implements WxUserService{

    @Autowired
    WxUserInfoRecordService wxUserInfoRecordService;

    /**
     * 获取用户基本信息,并且补全相关字段.保存到用户信息数据库中
     * @param wxAppId 微信公众号appId
     * @param openId 微信的openId
     * @return
     */
    @Override
    public UserInfo userInfoByOpenId(String wxAppId, String openId) {
        UserInfo userInfo = execToken(wxAppId,new GetUserInfoByOpenIdCmd(openId)).getUserInfo();
        userInfo.setAppId(wxAppId);
        wxUserInfoRecordService.saveUserInfo(userInfo);
        return userInfo;
    }

    @Override
    public OpenIdSet getAttentionOpenIds(String wxAppId,String openId) {
        return execToken(wxAppId,new GetAttentionOpenIdsCmd(openId)).getOpenIdSet();
    }

    @Override
    public Boolean updateRemark(String wxAppId, String openId, String remark) {
        execToken(wxAppId,new UpdateRemarkCmd(openId,remark));
        return true;
    }
}
