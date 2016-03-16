package com.mind.weixin.service;

import com.mind.proxy.wx.command.qrcode.CreateQrcodeTicketCmd;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serv on 2014/7/31.
 */
@Service
public class WxQrcodeServiceImpl extends BaseService implements WxQrcodeService {

    @Override
    public Map<String,String> createQrcodeTicket(String wxAppId, Long sceneId) {
        CreateQrcodeTicketCmd cmd = execToken(wxAppId, new CreateQrcodeTicketCmd(sceneId));
        Map<String,String> map = new HashMap<String, String>();
        map.put("ticket",cmd.getTicket());
        map.put("data",cmd.getData());
        map.put("url",cmd.getQrcodeUrl());
        return map;
    }

    @Override
    public Map<String,String> createQrcodeTicket(String wxAppId, Long sceneId, Integer expireSeconds) {
        CreateQrcodeTicketCmd cmd = execToken(wxAppId, new CreateQrcodeTicketCmd(sceneId,expireSeconds));
        Map<String,String> map = new HashMap<String, String>();
        map.put("ticket",cmd.getTicket());
        map.put("data",cmd.getData());
        map.put("url",cmd.getQrcodeUrl());
        return map;
    }
}
