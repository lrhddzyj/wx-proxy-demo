package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 2015/3/23.
 */
public class Item implements Serializable{

	@JsonProperty("media_id")
	private String mediaId;
	@JsonProperty("content")
	private ItemContent content ;
	@JsonProperty("update_time")
	private Date updateTime ;
	@JsonProperty("name")
	private String name ;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public ItemContent getContent() {
		return content;
	}

	public void setContent(ItemContent content) {
		this.content = content;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
