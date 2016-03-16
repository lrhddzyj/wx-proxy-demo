package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMediaMessage;
;

/**
 * Created by serv on 2014/7/23.
 */
public class ImageMessage extends BaseMediaMessage {
    @JacksonXmlProperty(localName = "PicUrl")
    protected String picUrl;

    @Override
    protected String initType() {
        return "image";
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
