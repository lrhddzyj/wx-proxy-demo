package com.mind.weixin.vo;

import java.io.Serializable;

/**
 * Created by serv on 2014/10/29.
 */
public class WxField implements Serializable {
    private String value;
    private String color;

    public WxField() {
    }

    public WxField(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
