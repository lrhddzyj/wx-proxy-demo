package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMediaMessage;

/**
 * Created by serv on 2014/7/23.
 */
public class VoiceMessage extends BaseMediaMessage {
    @JacksonXmlProperty(localName = "Format")
    protected String format;
    @JacksonXmlProperty(localName = "Recognition")
    protected String recognition;

    @Override
    protected String initType() {
        return "voice";
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
