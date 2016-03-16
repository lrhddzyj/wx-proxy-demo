package com.mind.weixin.message.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Item implements Serializable {
    @JacksonXmlProperty(localName = "PicMd5Sum")
    private String picMd5Sum;

    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }

    @Override
    public String toString() {
        return this.picMd5Sum;
    }
}