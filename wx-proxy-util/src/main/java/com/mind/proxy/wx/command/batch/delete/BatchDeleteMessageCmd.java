package com.mind.proxy.wx.command.batch.delete;


import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/20.
 */
public class BatchDeleteMessageCmd extends WxJsonCommand {

    public BatchDeleteMessageCmd(Long msgId) {
        super("deleteMessage");
        addVariable("msgId",msgId.toString());
    }


}
