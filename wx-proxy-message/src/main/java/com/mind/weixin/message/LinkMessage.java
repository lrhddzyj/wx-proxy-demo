package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMsgMessage;


/**
 * Created by serv on 2014/7/23.
 */
public class LinkMessage extends BaseMsgMessage {
    @JacksonXmlProperty(localName = "Title")
    protected String title;
    @JacksonXmlProperty(localName = "Description")
    protected String description;
    @JacksonXmlProperty(localName = "Url")
    protected String url;

    @Override
    protected String initType() {
        return "link";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
