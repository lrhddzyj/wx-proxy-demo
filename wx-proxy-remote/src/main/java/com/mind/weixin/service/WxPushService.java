package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Article;
import com.mind.weixin.vo.Music;
import com.mind.weixin.vo.WxField;

import java.util.List;
import java.util.Map;

/**
 * 客服消息接口
 * Created by serv on 2014/8/4.
 */
public interface WxPushService {
    /**
     * 发送模板消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param templateId 模板id
     * @param url 连接地址
     * @param topColor 颜色
     * @param data 数据集合
     */
    public String sendtemplateMessage(String wxAppId, String toUserOpenId, String templateId, String url, String topColor, Map<String, WxField> data) throws WeiXinException;
    /**
     * 发送文本消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param content 正文
     * @return 发送成功 true 失败false
     */
    public Boolean sendTextMessage(String wxAppId, String toUserOpenId, String content) throws WeiXinException;

    /**
     * 发送图片消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param mediaId 微信服务器上图片的mediaId
     * @return 发送成功 true 失败false
     */
    public Boolean sendImageMessage(String wxAppId, String toUserOpenId, String mediaId) throws WeiXinException;

    /**
     * 发送语音消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param mediaId 微信服务器上语音的mediaId
     * @return 成功true 失败false
     */
    public Boolean sendVoiceMessage(String wxAppId, String toUserOpenId, String mediaId) throws WeiXinException;

    /**
     * 发送视频消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param mediaId 视频文件的mediaId
     * @param title 视频文件的标题
     * @param description 视频文件的描述
     * @return 成功true 失败false
     */
    public Boolean sendVideoMessage(String wxAppId, String toUserOpenId, String mediaId, String title, String description) throws WeiXinException;

    /**
     * 发送音乐消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param music 音乐对象
     * @return 成功true 失败false
     */
    public Boolean sendMusicMessage(String wxAppId, String toUserOpenId, Music music) throws WeiXinException;

    /**
     * 发送图文消息
     * @param wxAppId 微信appId
     * @param toUserOpenId 发送目标的微信openId
     * @param articles 图文列表. 最多10条
     * @return 成功true 失败false
     */
    public Boolean sendArticlesMessage(String wxAppId, String toUserOpenId, List<Article> articles) throws WeiXinException;


}
