package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.MaterialCount;

/**
 * Created by user on 2015/3/23.
 */
public class GetMaterialCountCmd extends WxJsonCommand {

	private MaterialCount materialCount ;

	public GetMaterialCountCmd() {
		super("getMaterialCount");
	}

	@Override
	protected void afterExecuted(JsonNode jsonNode, String resultText) {
		materialCount = JsonUtils.json2Object(resultText,MaterialCount.class) ;
	}

	public MaterialCount getMaterialCount() {
		return materialCount;
	}
}
