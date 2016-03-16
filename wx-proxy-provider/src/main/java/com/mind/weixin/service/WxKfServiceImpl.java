package com.mind.weixin.service;

import com.mind.proxy.wx.command.kf.GetChatHistoryCmd;
import com.mind.proxy.wx.command.kf.GetKfListCmd;
import com.mind.proxy.wx.command.kf.GetOnlineKfListCmd;
import com.mind.weixin.vo.KfBaseInfo;
import com.mind.weixin.vo.KfChatInfo;
import com.mind.weixin.vo.KfOnlineInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2014/11/20.
 */
@Service
public class WxKfServiceImpl extends BaseService implements WxKfService{

    @Override
    public List<KfBaseInfo> getKfList(String appId) {
        return execToken(appId,new GetKfListCmd()).getInfoList();
    }

    @Override
    public List<KfOnlineInfo> getOnlineKfList(String appId) {
        return execToken(appId,new GetOnlineKfListCmd()).getOnlineInfos();
    }

    @Override
    public List<KfChatInfo> getChatHistory(String appId, Date startTime, Date endTime, int page, int pageSize) {
        return execToken(appId,new GetChatHistoryCmd(startTime,endTime,page,pageSize)).getChatInfoList();
    }

    @Override
    public List<KfChatInfo> getChatHistory(String appId, Date startTime, Date endTime, String openId, int page, int pageSize) {
        return execToken(appId,new GetChatHistoryCmd(startTime,endTime,openId,page,pageSize)).getChatInfoList();
    }
}
