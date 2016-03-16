package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.reply.node.VideoMediaNode;

/**
 * Created by serv on 2014/8/5.
 */
public class VideoReplyMessage extends BaseReplyMessage {

    @JacksonXmlProperty(localName = "Video")
    protected VideoMediaNode video;

    @Override
    public String initType() {
        return "video";
    }

    public VideoMediaNode getVideo() {
        return video;
    }

    public void setVideo(VideoMediaNode video) {
        this.video = video;
    }
}
