package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 群发模块的图文对象
 * Created by serv on 2014/8/1.
 */
public class News implements Serializable {
    /**
     * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * (必须)
     */
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    /**
     * 图文消息的作者
     * (非必须)
     */
    @JsonProperty("author")
    private String author;
    /**
     * 图文消息的标题
     * (必须)
     */
    @JsonProperty("title")
    private String title;
    /**
     * 在图文消息页面点击“阅读原文”后的页面
     * (非必须)
     */
    @JsonProperty("content_source_url")
    private String contentSourceUrl;
    /**
     * 图文消息页面的内容，支持HTML标签
     * (必须)
     */
    @JsonProperty("content")
    private String content;
    /**
     * 图文消息的描述
     * (非必须)
     */
    @JsonProperty("digest")
    private String digest;
    /**
     * 是否显示封面，1为显示，0为不显示
     * (非必须)
     */
    @JsonProperty("show_cover_pic")
    private int showCoverPic;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public int getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(int showCoverPic) {
        this.showCoverPic = showCoverPic;
    }
}
