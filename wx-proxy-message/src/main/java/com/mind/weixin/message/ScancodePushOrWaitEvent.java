package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.node.ScanCodeInfo;

/**
 * Created by serv on 2014/11/20.
 */
public class ScancodePushOrWaitEvent extends MenuEvent {
    @JacksonXmlProperty(localName = "ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }
}

