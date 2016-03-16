package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMediaMessage;

/**
 * Created by serv on 2014/7/23.
 */
public class VideoMessage extends BaseMediaMessage {
    @JacksonXmlProperty(localName = "ThumbMediaId")
    protected String thumbMediaId;

    @Override
    protected String initType() {
        return "video";
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
