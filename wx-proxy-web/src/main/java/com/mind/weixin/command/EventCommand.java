package com.mind.weixin.command;

import com.mind.weixin.message.TicketEvent;
import com.mind.weixin.message.base.BaseEventMessage;
import com.mind.weixin.service.WxUserInfoRecordService;
import com.mind.weixin.service.WxUserService;
import com.mind.weixin.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by serv on 2014/12/25.
 */
@Component
public class EventCommand {

    @Autowired
    WxUserService wxUserService;
    @Autowired
    WxUserInfoRecordService wxUserInfoRecordService;

    public void execute(BaseEventMessage message) {
        if(message.getEvent().equals("subscribe")){
            UserInfo userEntity = wxUserInfoRecordService.getUserInfo(message.getAppId(), message.getFromUserName());
            if(userEntity==null){//首次关注
                ((TicketEvent)message).setIsFirstSubscribe(true);
            }
            UserInfo userInfo = wxUserService.userInfoByOpenId(message.getAppId(), message.getFromUserName());
            userInfo.setAppId(message.getAppId());
            wxUserInfoRecordService.saveUserInfo(userInfo);
        }
        if(message.getEvent().equals("unsubscribe")){
            UserInfo userInfo = wxUserInfoRecordService.getUserInfo(message.getAppId(), message.getFromUserName());
            userInfo.setSubscribe(0);
            wxUserInfoRecordService.saveUserInfo(userInfo);
        }
    }
}
