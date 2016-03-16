package com.mind.proxy.wx.command.card;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class SetWhiteListCmd extends WxJsonCommand {

    public SetWhiteListCmd(List<String> openIds, List<String> usernames) {
        super("setWhiteList");
        if(openIds==null){
            openIds = new ArrayList<String>();
        }
        if(openIds==null){
            usernames = new ArrayList<String>();
        }
        addVariable("openIds", JsonUtils.object2Json(openIds));
        addVariable("userNames",JsonUtils.object2Json(usernames));
    }
}
