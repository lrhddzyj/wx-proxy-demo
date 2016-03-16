package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class UpdateCardDetail extends WxJsonCommand {

    public UpdateCardDetail(String cardJson) {
        super("updateCardDetail");
        addVariable("cardJson",cardJson);
    }
}
