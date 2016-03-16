package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.WxField;

import java.util.Map;

/**
 * 模板接口
 * Created by serv on 2014/12/30.
 */
public interface WxTemplateService {
    /**
     * 发送模板消息
     * @param wxAppId 公众号appId
     * @param toUserOpenId 发送目标的微信openId
     * @param templateId 模板id
     * @param url 连接地址
     * @param topColor 颜色
     * @param data 数据集合
     */
    public String sendtemplateMessage(String wxAppId, String toUserOpenId, String templateId, String url, String topColor, Map<String, WxField> data) throws WeiXinException;

    /**
     * 设置行业类型
     * @param wxAppId 公众号appId
     * @param masterIndustryId 主行业id
     * @param subIndustryId 次行业id
     */
    public void updateIndustry(String wxAppId, Integer masterIndustryId, Integer subIndustryId) throws WeiXinException;

    /**
     * 根据模板编号获取模板id,并设置到后台
     * @param wxAppId 公众号appId
     * @param templateCode 模板编号
     * @return
     */
    public String addTemplate(String wxAppId, String templateCode) throws WeiXinException;
}
