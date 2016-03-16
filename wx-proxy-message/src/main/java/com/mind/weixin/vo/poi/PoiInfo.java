package com.mind.weixin.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by user on 2015/6/10.
 */
public class PoiInfo implements Serializable {

    @JsonProperty("base_info")
    private PoiBaseInfo poiBaseInfo;


    public PoiBaseInfo getPoiBaseInfo() {
        return poiBaseInfo;
    }

    public void setPoiBaseInfo(PoiBaseInfo poiBaseInfo) {
        this.poiBaseInfo = poiBaseInfo;
    }
}
