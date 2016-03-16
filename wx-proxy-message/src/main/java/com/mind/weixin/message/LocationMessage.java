package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseMediaMessage;

/**
 * Created by serv on 2014/7/23.
 */
public class LocationMessage extends BaseMediaMessage {
    @JacksonXmlProperty(localName = "Location_X")
    protected float locationX;
    @JacksonXmlProperty(localName = "Location_Y")
    protected float locationY;
    @JacksonXmlProperty(localName = "Scale")
    protected int scale;
    @JacksonXmlProperty(localName = "Label")
    protected String label;

    @Override
    protected String initType() {
        return "location";
    }

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
}
