package com.mind.proxy.wx.command.user;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/17.
 */
public class UpdateRemarkCmd extends WxJsonCommand {


    public UpdateRemarkCmd(String openId,String remark) {
        super("updateRemark");
        addVariable("openId",openId);
        addVariable("remark",remark);
    }


}
