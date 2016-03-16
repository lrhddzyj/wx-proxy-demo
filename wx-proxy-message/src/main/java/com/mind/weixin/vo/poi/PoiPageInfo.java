package com.mind.weixin.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/6/10.
 */
public class PoiPageInfo implements Serializable {

    @JsonProperty("errcode")
    private String errCode ;

    @JsonProperty("errmsg")
    private String errMsg ;

    @JsonProperty("business_list")
    private List<PoiInfo> businessList ;

    @JsonProperty("total_count")
    private String totalCount ;


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<PoiInfo> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<PoiInfo> businessList) {
        this.businessList = businessList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
