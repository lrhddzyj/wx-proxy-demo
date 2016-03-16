package com.mind.weixin.message.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class SendLocationInfo implements Serializable {
    @JacksonXmlProperty(localName = "Location_X")
    protected float locationX;
    @JacksonXmlProperty(localName = "Location_Y")
    protected float locationY;
    @JacksonXmlProperty(localName = "Scale")
    private int scale;
    @JacksonXmlProperty(localName = "Label")
    private String label;
    @JacksonXmlProperty(localName = "Poiname")
    private String poiname;

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }
}
