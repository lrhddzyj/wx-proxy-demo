package com.mind.proxy.wx.command.shakearound;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/5/14.
 */
public class BindlocationDeviceCmd extends WxJsonCommand {

    public BindlocationDeviceCmd(String deviceId,String poiId) {
        super("bindlocation");
        addVariable("deviceId", deviceId);
        addVariable("poiId",poiId);
    }
}
