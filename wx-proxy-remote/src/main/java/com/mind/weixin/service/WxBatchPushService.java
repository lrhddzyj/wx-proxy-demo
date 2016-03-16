package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.News;

import java.util.List;

/**
 * 高级群发接口
 * Created by serv on 2014/8/1.
 */
public interface WxBatchPushService {

    /**
     * 上传图文消息
     * @param wxAppId 微信appId
     * @param news 图文消息，一个图文消息支持1到10条图文
     * @return 媒体文件/图文消息上传后获取的唯一标识
     */
    public String uploadNews(String wxAppId, List<News> news) throws WeiXinException;

    /**
     * 发送图文消息
     * @param wxAppId 微信appId
     * @param groupId 分组id
     * @param newsId 图文消息上传后获取的唯一标识
     * @return 消息ID
     */
    public Long sendNewsMessage(String wxAppId, Integer groupId, String newsId) throws WeiXinException;
    /**
     * 发送图文消息
     * @param wxAppId 微信appId
     * @param users 用户集合
     * @param newsId 图文消息上传后获取的唯一标识
     * @return 消息ID
     */
    public Long sendNewsMessage(String wxAppId, List<String> users, String newsId) throws WeiXinException;
    /**
     * 发送图文消息
     * @param wxAppId 微信appId
     * @param newsId 图文消息上传后获取的唯一标识
     * @return 消息ID
     */
    @Deprecated
    public List<Long> sendNewsMessage(String wxAppId, String newsId) throws WeiXinException;
    /**
     * 发送图文消息
     * @param wxAppId 微信appId
     * @param newsId 图文消息上传后获取的唯一标识
     * @return 消息ID
     */
    public Long sendAllNewsMessage(String wxAppId, String newsId) throws WeiXinException;

    /**
     * 发送文本消息
     * @param wxAppId 微信appId
     * @param groupId 分组id
     * @param content 文本消息正文
     * @return 消息ID
     */
    public Long sendTextMessage(String wxAppId, Integer groupId, String content) throws WeiXinException;
    /**
     * 发送文本消息
     * @param wxAppId 微信appId
     * @param users 用户openid集合
     * @param content 文本消息正文
     * @return 消息ID
     */
    public Long sendTextMessage(String wxAppId, List<String> users, String content) throws WeiXinException;
    /**
     * 发送文本消息
     * @param wxAppId 微信appId
     * @param content 文本消息正文
     * @return 消息ID
     */
    @Deprecated
    public List<Long> sendTextMessage(String wxAppId, String content) throws WeiXinException;
    /**
     * 发送文本消息
     * @param wxAppId 微信appId
     * @param content 文本消息正文
     * @return 消息ID
     */
    public Long sendAllTextMessage(String wxAppId, String content) throws WeiXinException;

    /**
     * 发送语音消息
     * @param wxAppId 微信appId
     * @param groupId 分组id
     * @param mediaId 语音文件上传后的mediaId
     * @return 消息ID
     */
    public Long sendVoiceMessage(String wxAppId, Integer groupId, String mediaId) throws WeiXinException;
    /**
     * 发送语音消息
     * @param wxAppId 微信appId
     * @param users 用户openid集合
     * @param mediaId 语音文件上传后的mediaId
     * @return 消息ID
     */
    public Long sendVoiceMessage(String wxAppId, List<String> users, String mediaId) throws WeiXinException;
    /**
     * 发送语音消息
     * @param wxAppId 微信appId
     * @param mediaId 语音文件上传后的mediaId
     * @return 消息ID
     */
    @Deprecated
    public List<Long> sendVoiceMessage(String wxAppId, String mediaId) throws WeiXinException;
    /**
     * 发送语音消息
     * @param wxAppId 微信appId
     * @param mediaId 语音文件上传后的mediaId
     * @return 消息ID
     */
    public Long sendAllVoiceMessage(String wxAppId, String mediaId) throws WeiXinException;

    /**
     * 发送图片消息
     * @param wxAppId 微信appId
     * @param groupId 分组id
     * @param mediaId 图片上传后的mediaId
     * @return 消息ID
     */
    public Long sendImageMessage(String wxAppId, Integer groupId, String mediaId) throws WeiXinException;
    /**
     * 发送图片消息
     * @param wxAppId 微信appId
     * @param users 用户openid集合
     * @param mediaId 图片上传后的mediaId
     * @return 消息ID
     */
    public Long sendImageMessage(String wxAppId, List<String> users, String mediaId) throws WeiXinException;
    /**
     * 发送图片消息
     * @param wxAppId 微信appId
     * @param mediaId 图片上传后的mediaId
     * @return 消息ID
     */
    @Deprecated
    public List<Long> sendImageMessage(String wxAppId, String mediaId) throws WeiXinException;
    /**
     * 发送图片消息
     * @param wxAppId 微信appId
     * @param mediaId 图片上传后的mediaId
     * @return 消息ID
     */
    @Deprecated
    public Long sendAllImageMessage(String wxAppId, String mediaId) throws WeiXinException;

    /**
     * 发送视频消息
     * @param wxAppId 微信appId
     * @param groupId 分组id
     * @param title 视频的标题
     * @param description 视频的描述信息
     * @param mediaId 视频调用基础模块上传后返回的mediaId
     * @return 消息ID
     */
    public Long sendVideoMessage(String wxAppId, Integer groupId, String title, String description, String mediaId) throws WeiXinException;
    /**
     * 发送视频消息
     * @param wxAppId 微信appId
     * @param users 用户openid集合
     * @param title 视频的标题
     * @param description 视频的描述信息
     * @param mediaId 视频调用基础模块上传后返回的mediaId
     * @return 消息ID
     */
    public Long sendVideoMessage(String wxAppId, List<String> users, String title, String description, String mediaId) throws WeiXinException;
    /**
     * 发送视频消息
     * @param wxAppId 微信appId
     * @param title 视频的标题
     * @param description 视频的描述信息
     * @param mediaId 视频调用基础模块上传后返回的mediaId
     * @return 消息ID
     */
    @Deprecated
    public List<Long> sendVideoMessage(String wxAppId, String title, String description, String mediaId) throws WeiXinException;
    /**
     * 发送视频消息
     * @param wxAppId 微信appId
     * @param title 视频的标题
     * @param description 视频的描述信息
     * @param mediaId 视频调用基础模块上传后返回的mediaId
     * @return 消息ID
     */
    @Deprecated
    public Long sendAllVideoMessage(String wxAppId, String title, String description, String mediaId) throws WeiXinException;

    /**
     * 删除发送的消息
     * @param wxAppId 微信appId
     * @param msgId
     */
    public Boolean deleteMessage(String wxAppId, Long msgId) throws WeiXinException;

}
