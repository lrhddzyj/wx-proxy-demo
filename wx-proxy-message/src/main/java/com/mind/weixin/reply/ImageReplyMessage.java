package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.reply.node.MediaNode;

/**
 * Created by serv on 2014/8/5.
 */
public class ImageReplyMessage extends BaseReplyMessage {

    @JacksonXmlProperty(localName = "Image")
    private MediaNode image;

    public MediaNode getImage() {
        return image;
    }

    public void setImage(MediaNode image) {
        this.image = image;
    }

    @Override
    public String initType() {
        return "image";
    }
}
