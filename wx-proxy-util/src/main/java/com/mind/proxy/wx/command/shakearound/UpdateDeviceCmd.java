package com.mind.proxy.wx.command.shakearound;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/5/14.
 */
public class UpdateDeviceCmd extends WxJsonCommand {

    public UpdateDeviceCmd(String deviceId , String comment) {
        super("updateDevice");
        addVariable("deviceId", deviceId);
        addVariable("comment",comment);
    }

//    public UpdateDeviceCmd(String uuid , String major , String minor , String comment) {
//        super("updateDevice2");
//        addVariable("uuid", uuid);
//        addVariable("major", major);
//        addVariable("minor", minor);
//        addVariable("comment",comment);
//    }


}
