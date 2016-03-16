package com.mind.proxy.wx.command.media;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.NewsItem;

import java.util.List;

/**
 * Created by user on 2015/3/23.
 */
public class UpdateNewsCmd extends WxJsonCommand {
	public UpdateNewsCmd(String mediaId,String index,List<NewsItem> materials) {
		super("updateNews");
		addVariable("mediaId",mediaId);
		addVariable("index",index);
		addVariable("articles", JsonUtils.object2Json(materials));
	}

}
