package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.reply.node.MusicNode;

/**
 * Created by serv on 2014/8/5.
 */
public class MusicReplyMessage extends BaseReplyMessage {
    @JacksonXmlProperty(localName = "Music")
    private MusicNode music;

    @Override
    public String initType() {
        return "music";
    }

    public MusicNode getMusic() {
        return music;
    }

    public void setMusic(MusicNode music) {
        this.music = music;
    }
}
