package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 响应文本消息
 * Created by serv on 2014/8/5.
 */
public class TextReplyMessage extends BaseReplyMessage{
    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    @JacksonXmlProperty(localName = "Content")
    protected String content;

    @Override
    public String initType() {
        return "text";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
