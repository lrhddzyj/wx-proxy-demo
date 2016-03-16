package com.mind.proxy.wx.command.url;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/17.
 */
public class Long2ShortCmd extends WxJsonCommand {

    private String longUrl;
    private String shortUrl;

    public Long2ShortCmd(String longUrl) {
        super("long2Short");
        this.longUrl = longUrl;
        addVariable("longUrl", longUrl);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        shortUrl = jsonNode.get("short_url").asText();
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
