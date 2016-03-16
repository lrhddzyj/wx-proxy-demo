package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;
import com.mind.weixin.message.node.SendPicsInfo;

/**
 * Created by serv on 2014/11/19.
 */
public class PhotoEvent extends BaseEventMessage {

    @JacksonXmlProperty(localName = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

}

