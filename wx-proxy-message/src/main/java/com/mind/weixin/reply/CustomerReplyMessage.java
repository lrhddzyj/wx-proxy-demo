package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2014/11/20.
 */
public class CustomerReplyMessage extends BaseReplyMessage {

    @JacksonXmlProperty(localName = "TransInfo")
    private String transInfo;

    @Override
    public String initType() {
        return "transfer_customer_service";
    }

    public String getTransInfo() {
        return transInfo;
    }

    public void setTransInfo(String transInfo) {
        this.transInfo = transInfo;
    }
}
