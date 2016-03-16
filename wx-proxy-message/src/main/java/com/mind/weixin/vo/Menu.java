package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 2014/7/28.
 */
public class Menu implements Serializable {

    @JsonProperty("type")
    private MenuType type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;
    @JsonProperty("url")
    private String url;
    @JsonProperty("sub_button")
    private List<Menu> subButton;

    public Menu() {
    }

    public Menu(String name, String key, MenuType type) {
        this.name = name;
        this.key = key;
        this.type = type;
    }

    public Menu(String name, String key, MenuType type,String url) {
        this.name = name;
        this.key = key;
        this.type = type;
        this.url = url;
    }

    public Menu(String name, String key, MenuType type, List<Menu> subButton) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.subButton = subButton;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public List<Menu> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<Menu> subButton) {
        this.subButton = subButton;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public enum MenuType{
        /**
         * 点击推事件
         */
        click,
        /**
         * 跳转URL
         */
        view,
        /**
         * 扫码推事件
         */
        scancode_push,
        /**
         * 扫码推事件且弹出“消息接收中”提示框
         */
        scancode_waitmsg,
        /**
         * 弹出系统拍照发图
         */
        pic_sysphoto,
        /**
         * 弹出拍照或者相册发图
         */
        pic_photo_or_album,
        /**
         * 弹出微信相册发图器
         */
        pic_weixin,
        /**
         * 弹出地理位置选择器
         */
        location_select
    }
}
