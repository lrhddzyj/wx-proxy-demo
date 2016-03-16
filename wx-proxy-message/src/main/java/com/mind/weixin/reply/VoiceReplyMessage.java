package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.reply.node.MediaNode;

/**
 * Created by serv on 2014/8/5.
 */
public class VoiceReplyMessage extends BaseReplyMessage {

    @JacksonXmlProperty(localName = "Voice")
    protected MediaNode voice;

    @Override
    public String initType() {
        return "voice";
    }

    public MediaNode getVoice() {
        return voice;
    }

    public void setVoice(MediaNode voice) {
        this.voice = voice;
    }
}
