package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/19.
 */
public class GetVideoMediaIdCmd extends WxJsonCommand {

    private String mediaId;

    //此处media_id需通过基础支持中的上传下载多媒体文件来得到
    public GetVideoMediaIdCmd(String title, String description, String mediaId) {
        super("convertVideoId");
        addVariable("title", title);
        addVariable("description",description);
        addVariable("mediaId",mediaId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        mediaId = jsonNode.path("media_id").asText();
    }

    public String getMediaId() {
        return mediaId;
    }
}
