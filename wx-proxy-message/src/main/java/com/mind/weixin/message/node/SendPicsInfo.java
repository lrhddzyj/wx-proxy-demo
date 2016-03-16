package com.mind.weixin.message.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class SendPicsInfo implements Serializable {
    @JacksonXmlProperty(localName = "Count")
    private int count;

    @JacksonXmlProperty(localName = "PicList")
    private PicList picList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PicList getPicList() {
        return picList;
    }

    public void setPicList(PicList picList) {
        this.picList = picList;
    }
}

