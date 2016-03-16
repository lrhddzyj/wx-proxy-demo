package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.message.base.BaseEventMessage;

/**
 * Created by serv on 2014/8/1.
 */
public class LocationEvent extends BaseEventMessage {
    @JacksonXmlProperty(localName = "Latitude")
    protected float latitude;
    @JacksonXmlProperty(localName = "Longitude")
    protected float longitude;
    @JacksonXmlProperty(localName = "Precision")
    protected float precision;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getPrecision() {
        return precision;
    }

    public void setPrecision(float precision) {
        this.precision = precision;
    }
}
