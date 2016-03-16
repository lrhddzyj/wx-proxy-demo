package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.KfBaseInfo;
import com.mind.weixin.vo.KfChatInfo;
import com.mind.weixin.vo.KfOnlineInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2014/11/20.
 */
public interface WxKfService {

    /**
     * 获取客服列表信息
     * @return
     */
    public List<KfBaseInfo> getKfList(String appId) throws WeiXinException;

    /**
     * 获取在线客服信息
     * @return
     */
    public List<KfOnlineInfo> getOnlineKfList(String appId) throws WeiXinException;

    /**
     * 获取appId下面的聊天记录
     * @param appId 公众号id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 第几页, 从1 开始
     * @param pageSize 每页多少条
     * @return
     */
    public List<KfChatInfo> getChatHistory(String appId, Date startTime, Date endTime, int page, int pageSize) throws WeiXinException;

    /**
     * 获取指定openId下面的聊天记录
     * @param appId 公众号id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param openId 用户的openId
     * @param page 第几页, 从1 开始
     * @param pageSize 每页多少条
     * @return
     */
    public List<KfChatInfo> getChatHistory(String appId, Date startTime, Date endTime, String openId, int page, int pageSize) throws WeiXinException;
}
