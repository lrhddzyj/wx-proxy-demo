package com.mind.weixin.service;

import com.google.common.collect.Lists;
import com.mind.proxy.wx.command.batch.*;
import com.mind.proxy.wx.command.batch.delete.BatchDeleteMessageCmd;
import com.mind.proxy.wx.command.media.BatchUploadNewsCmd;
import com.mind.proxy.wx.command.media.GetVideoMediaIdCmd;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serv on 2014/8/1.
 */
@Service
public class WxBatchPushServiceImpl extends BaseService implements WxBatchPushService {

    @Override
    public String uploadNews(String wxAppId, List<News> news) {
        return execToken(wxAppId, new BatchUploadNewsCmd(news)).getMediaId();
    }

    @Override
    public Long sendNewsMessage(String wxAppId, Integer groupId, String newsId) {
        return execToken(wxAppId, new BatchSendNewsMessageCmd(groupId, newsId)).getMsgId();
    }

    @Override
    public Long sendNewsMessage(String wxAppId, List<String> users, String newsId) {
        return execToken(wxAppId,new BatchSendNewsMessageCmd(users,newsId)).getMsgId();
    }

    @Override
    public Long sendTextMessage(String wxAppId, Integer groupId, String content) {
        return execToken(wxAppId,new BatchSendTextMessageCmd(groupId,content)).getMsgId();
    }

    @Override
    public Long sendTextMessage(String wxAppId, List<String> users, String content) {
        return execToken(wxAppId,new BatchSendTextMessageCmd(users,content)).getMsgId();
    }

    @Override
    public Long sendVoiceMessage(String wxAppId, Integer groupId, String mediaId) {
        return execToken(wxAppId,new BatchSendVoiceMessageCmd(groupId,mediaId)).getMsgId();
    }

    @Override
    public Long sendVoiceMessage(String wxAppId, List<String> users, String mediaId) {
        return execToken(wxAppId,new BatchSendVoiceMessageCmd(users,mediaId)).getMsgId();
    }

    @Override
    public Long sendImageMessage(String wxAppId, Integer groupId, String mediaId) {
        return execToken(wxAppId,new BatchSendImageMessageCmd(groupId,mediaId)).getMsgId();
    }

    @Override
    public Long sendImageMessage(String wxAppId, List<String> users, String mediaId) {
        return execToken(wxAppId,new BatchSendImageMessageCmd(users,mediaId)).getMsgId();
    }

    @Override
    public Long sendVideoMessage(String wxAppId, Integer groupId, String title, String description, String mediaId) {
        GetVideoMediaIdCmd videoMediaIdCmd = new GetVideoMediaIdCmd(title,description,mediaId);
        String videoId = execToken(wxAppId, videoMediaIdCmd).getMediaId();
        return execToken(wxAppId,new BatchSendVideoMessageCmd(groupId,videoId)).getMsgId();
    }

    @Override
    public Long sendVideoMessage(String wxAppId, List<String> users, String title, String description, String mediaId) {
        GetVideoMediaIdCmd videoMediaIdCmd = new GetVideoMediaIdCmd(title,description,mediaId);
        String videoId = execToken(wxAppId, videoMediaIdCmd).getMediaId();
        return execToken(wxAppId,new BatchSendVideoMessageCmd(users,title,description,videoId)).getMsgId();
    }

    @Override
    public Boolean deleteMessage(String wxAppId, Long msgId) {
        execToken(wxAppId,new BatchDeleteMessageCmd(msgId));
        return true;
    }

    @Deprecated
    @Override
    public List<Long> sendNewsMessage(String wxAppId, String newsId) {
        return Lists.newArrayList(execToken(wxAppId, new BatchSendNewsMessageCmd(newsId)).getMsgId());
    }

    @Override
    public Long sendAllNewsMessage(String wxAppId, String newsId) throws WeiXinException {
        return execToken(wxAppId, new BatchSendNewsMessageCmd(newsId)).getMsgId();
    }

    @Deprecated
    @Override
    public List<Long> sendTextMessage(String wxAppId, String content) {
        return Lists.newArrayList(execToken(wxAppId, new BatchSendTextMessageCmd(content)).getMsgId());
    }

    @Override
    public Long sendAllTextMessage(String wxAppId, String content) throws WeiXinException {
        return execToken(wxAppId, new BatchSendTextMessageCmd(content)).getMsgId();
    }

    @Deprecated
    @Override
    public List<Long> sendVoiceMessage(String wxAppId, String mediaId) {
        return Lists.newArrayList(execToken(wxAppId, new BatchSendVoiceMessageCmd(mediaId)).getMsgId());
    }

    @Override
    public Long sendAllVoiceMessage(String wxAppId, String mediaId) throws WeiXinException {
        return execToken(wxAppId, new BatchSendVoiceMessageCmd(mediaId)).getMsgId();
    }

    @Deprecated
    @Override
    public List<Long> sendImageMessage(String wxAppId, String mediaId) {
        return Lists.newArrayList(execToken(wxAppId, new BatchSendImageMessageCmd(mediaId)).getMsgId());
    }

    @Override
    public Long sendAllImageMessage(String wxAppId, String mediaId) throws WeiXinException {
        return execToken(wxAppId, new BatchSendImageMessageCmd(mediaId)).getMsgId();
    }

    @Deprecated
    @Override
    public List<Long> sendVideoMessage(String wxAppId, String title, String description, String mediaId) {
        GetVideoMediaIdCmd videoMediaIdCmd = new GetVideoMediaIdCmd(title,description,mediaId);
        String videoId = execToken(wxAppId, videoMediaIdCmd).getMediaId();
        return Lists.newArrayList(execToken(wxAppId, new BatchSendVideoMessageCmd(videoId)).getMsgId());
    }

    @Override
    public Long sendAllVideoMessage(String wxAppId, String title, String description, String mediaId) throws WeiXinException {
        GetVideoMediaIdCmd videoMediaIdCmd = new GetVideoMediaIdCmd(title,description,mediaId);
        String videoId = execToken(wxAppId, videoMediaIdCmd).getMediaId();
        return execToken(wxAppId, new BatchSendVideoMessageCmd(videoId)).getMsgId();
    }
}
