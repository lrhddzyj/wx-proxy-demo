package com.mind.weixin.message.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2014/7/23.
 */
public abstract class BaseMediaMessage extends BaseMsgMessage {

    @JacksonXmlProperty(localName = "MediaId")
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
