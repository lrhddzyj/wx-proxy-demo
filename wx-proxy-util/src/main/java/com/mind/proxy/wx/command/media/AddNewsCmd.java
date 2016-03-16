package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.NewsItem;

import java.util.List;

/**
 * Created by user on 2015/3/23.
 */
public class AddNewsCmd extends WxJsonCommand {

	private String mediaId;

	public AddNewsCmd(List<NewsItem> items) {
		super("addNews");
		addVariable("json",JsonUtils.object2Json(items));
	}

	@Override
	protected void afterExecuted(JsonNode jsonNode, String resultText) {
		mediaId = jsonNode.path("media_id").asText();
	}

	public String getMediaId() {
		return mediaId;
	}
}
