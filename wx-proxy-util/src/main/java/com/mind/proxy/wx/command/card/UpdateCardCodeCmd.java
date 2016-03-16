package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/7/1.
 */
public class UpdateCardCodeCmd extends WxJsonCommand {

    public UpdateCardCodeCmd(String code,String cardId,String newCode) {
        super("updateCardCode");
        addVariable("code", code);
        addVariable("cardId", cardId);
        addVariable("newCode",newCode);
    }
}
