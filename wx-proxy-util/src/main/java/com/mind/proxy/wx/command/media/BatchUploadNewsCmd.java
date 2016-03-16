package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.News;

import java.util.List;

/**
 * Created by serv on 2015/3/18.
 */
public class BatchUploadNewsCmd extends WxJsonCommand {

    private String mediaId;

    public BatchUploadNewsCmd(List<News> news) {
        super("uploadNews");
        if(news!=null&&news.size()>10){
            throw new WeiXinException(90004,"少发点吧,顶多10条!");
        }
        addVariable("articles", JsonUtils.object2Json(news));
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        mediaId = jsonNode.path("media_id").asText();
    }

    public String getMediaId() {
        return mediaId;
    }

}
