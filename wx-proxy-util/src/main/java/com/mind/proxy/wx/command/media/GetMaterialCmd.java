package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.ItemContent;

/**
 * Created by user on 2015/3/23.
 */
public class GetMaterialCmd  extends WxJsonCommand {

	private ItemContent itemContent ;

	public GetMaterialCmd(String mediaId) {
		super("getMaterial");
		addVariable("mediaId",mediaId);
	}

	@Override
	protected void afterExecuted(JsonNode jsonNode, String resultText) {
		itemContent = JsonUtils.json2Object(resultText, ItemContent.class);
	}

	public ItemContent getItemContent() {
		return itemContent;
	}
}
