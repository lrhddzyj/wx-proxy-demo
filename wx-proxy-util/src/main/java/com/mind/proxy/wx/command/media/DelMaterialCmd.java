package com.mind.proxy.wx.command.media;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by user on 2015/3/23.
 */
public class DelMaterialCmd extends WxJsonCommand {

	public DelMaterialCmd(String mediaId) {
		super("delMaterial");
		addVariable("mediaId",mediaId);
	}
}
