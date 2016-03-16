package com.mind.weixin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by serv on 2014/11/24.
 */
@Document
public class UserInfo extends com.mind.weixin.vo.UserInfo implements Serializable{

    /**
     * 用户的唯一标识
     */
    @Id
    private String openId;

    @Override
    public String getOpenId() {
        return openId;
    }

    @Override
    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
