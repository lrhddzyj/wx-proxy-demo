package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMsgMessage;

/**
 * Created by serv on 2014/7/23.
 */
public class TextMessage extends BaseMsgMessage {
    @JacksonXmlProperty(localName = "Content")
    protected String content;

    @Override
    protected String initType() {
        return "text";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
