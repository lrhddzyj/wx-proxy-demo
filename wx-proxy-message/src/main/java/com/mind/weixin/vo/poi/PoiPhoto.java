package com.mind.weixin.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by user on 2015/6/10.
 */
public class PoiPhoto implements Serializable {

    @JsonProperty("photo_url")
    private String photoUrl ;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
