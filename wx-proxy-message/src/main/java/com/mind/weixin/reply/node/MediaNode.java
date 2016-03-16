package com.mind.weixin.reply.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/8/5.
 */
public class MediaNode implements Serializable {

    @JacksonXmlProperty(localName = "MediaId")
    private String mediaId;

    public MediaNode(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
