package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/7/1.
 */
public class DeleteCardCmd extends WxJsonCommand {

    public DeleteCardCmd(String cardId) {
        super("deleteCard");
        addVariable("cardId",cardId);
    }
}
