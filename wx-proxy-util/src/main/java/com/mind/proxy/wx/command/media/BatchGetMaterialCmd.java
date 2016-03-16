package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.Material;

/**
 * Created by user on 2015/3/23.
 */
public class BatchGetMaterialCmd extends WxJsonCommand {

	private Material material ;

	public BatchGetMaterialCmd(String type,int offset,int count) {
		super("batchGetMaterial");
		addVariable("type",type);
		addVariable("offset",String.valueOf(offset));
		addVariable("count",String.valueOf(count));
	}

	@Override
	protected void afterExecuted(JsonNode jsonNode, String resultText) {
		material = JsonUtils.json2Object(resultText, Material.class);
	}

	public Material getMaterial() {
		return material;
	}
}
