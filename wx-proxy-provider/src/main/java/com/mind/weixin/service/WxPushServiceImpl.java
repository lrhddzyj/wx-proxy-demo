package com.mind.weixin.service;

import com.mind.proxy.wx.command.push.*;
import com.mind.proxy.wx.command.template.SendtemplateMessageCmd;
import com.mind.weixin.vo.Article;
import com.mind.weixin.vo.Music;
import com.mind.weixin.vo.WxField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by serv on 2014/8/4.
 */
@Service
public class WxPushServiceImpl extends BaseService implements WxPushService {

    @Override
    public String sendtemplateMessage(String wxAppId, String toUserOpenId, String templateId, String url, String topColor, Map<String, WxField> data) {
        if(StringUtils.isEmpty(url)){
            return execToken(wxAppId,new SendtemplateMessageCmd(toUserOpenId,templateId,topColor,data)).getMessageId();
        }else{
            return execToken(wxAppId,new SendtemplateMessageCmd(toUserOpenId,templateId,url,topColor,data)).getMessageId();
        }
    }

    @Override
    public Boolean sendTextMessage(String wxAppId, String toUserOpenId, String content) {
        execToken(wxAppId, new SendTextMessageCmd(toUserOpenId, content));
        return true;
    }

    @Override
    public Boolean sendImageMessage(String wxAppId, String toUserOpenId, String mediaId) {
        execToken(wxAppId,new SendImageMessageCmd(toUserOpenId,mediaId));
        return true;
    }

    @Override
    public Boolean sendVoiceMessage(String wxAppId, String toUserOpenId, String mediaId) {
        execToken(wxAppId,new SendVoiceMessageCmd(toUserOpenId,mediaId));
        return true;
    }

    @Override
    public Boolean sendVideoMessage(String wxAppId, String toUserOpenId, String mediaId, String title, String description) {
        execToken(wxAppId,new SendVideoMessageCmd(toUserOpenId,mediaId,title,description));
        return true;
    }

    @Override
    public Boolean sendMusicMessage(String wxAppId, String toUserOpenId, Music music) {
        execToken(wxAppId,new SendMusicMessageCmd(toUserOpenId,music));
        return true;
    }

    @Override
    public Boolean sendArticlesMessage(String wxAppId, String toUserOpenId, List<Article> articles) {
        execToken(wxAppId,new SendArticlesMessageCmd(toUserOpenId,articles));
        return true;
    }

}
