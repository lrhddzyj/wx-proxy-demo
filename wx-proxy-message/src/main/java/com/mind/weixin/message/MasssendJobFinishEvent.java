package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2014/8/1.
 */
public class MasssendJobFinishEvent extends StatusEvent {
    @JacksonXmlProperty(localName = "MsgID")
    private long msgID;//请注意,大小写 跟 父类的 msgId 有区别 , 不知道腾讯是怎么想的. 群发的消息ID
    @JacksonXmlProperty(localName = "TotalCount")
    private int totalCount;
    /**
     * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
     */
    @JacksonXmlProperty(localName = "FilterCount")
    private int filterCount;
    @JacksonXmlProperty(localName = "SentCount")
    private int sentCount;
    @JacksonXmlProperty(localName = "ErrorCount")
    private int errorCount;

    public long getMsgID() {
        return msgID;
    }

    public void setMsgID(long msgID) {
        this.msgID = msgID;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(int filterCount) {
        this.filterCount = filterCount;
    }

    public int getSentCount() {
        return sentCount;
    }

    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }
}
