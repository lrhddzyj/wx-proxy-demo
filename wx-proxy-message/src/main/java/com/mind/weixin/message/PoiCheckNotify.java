package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;

/**
 * Created by user on 2015/6/10.
 */
public class PoiCheckNotify extends BaseEventMessage {

    @JacksonXmlProperty(localName = "UniqId")
    private String uniqId ;

    @JacksonXmlProperty(localName = "PoiId")
    private String poiId ;

    @JacksonXmlProperty(localName = "result")
    private String result ;

    @JacksonXmlProperty(localName = "msg")
    private String msg ;


    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
