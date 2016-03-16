package com.mind.weixin.message.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class ScanCodeInfo implements Serializable {
    @JacksonXmlProperty(localName = "ScanType")
    private String scanType;
    @JacksonXmlProperty(localName = "ScanResult")
    private String scanResult;

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}