package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/3/23.
 */
public class ItemContent implements Serializable{
	@JsonProperty("news_item")
	private List<NewsItem> newsItems ;
}
