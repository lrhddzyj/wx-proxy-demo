package com.mind.weixin.vo.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by user on 2015/6/10.
 *
 * 注：每个用户月仅能收到 4条公告消息 公告消息 。
 */
public class CardBulletin implements Serializable {

    /**
     * 卡券的code码。
     *
     * 必填
     */
    @JsonProperty("code")
    private String code ;

    /**
     * 展示 公告的 卡券 ID 。
     *
     * 必填
     */
    @JsonProperty("card_id")
    private String cardId ;

    /**
     * 公告 展示截止时间 Unix时间戳格式
     * 特别注意，更新公告解释时间仅支持前移，不支持延后
     *
     * 必填
     */
    @JsonProperty("end_time")
    private long endTime ;

    /**
     * 公告文字，不超过16个汉字
     *
     * 非必填
     */
    @JsonProperty("text")
    private String text ;

    /**
     * 点击 公告跳转的URL
     *
     * 非必填
     */
    @JsonProperty("url")
    private String url ;

    /**
     * 可配置公告过期后出现在历史公告列表中的图片。需调用上传logo接口获取URL
     *
     * 非必填
     */
    @JsonProperty("thumb_url")
    private String thumbUrl ;

    /**
     * 以创建公告的时间作为更新该用户手上会员卡唯一标识。
     *
     * 非必填
     */
    @JsonProperty("createTime")
    private long createTime ;

    /**
     * 填写 true则关闭该公告展示
     * 默认 为 false
     * 特别 注 意，公告更新为关闭状态后不可恢复。
     *
     * 非必填
     */
    @JsonProperty("close")
    private String close ;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
