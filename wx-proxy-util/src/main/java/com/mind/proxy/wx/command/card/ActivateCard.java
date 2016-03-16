package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/4/9.
 */
public class ActivateCard extends WxJsonCommand {

    public ActivateCard(String json) {
        super("activateCard");
        addVariable("json",json);
    }
}
