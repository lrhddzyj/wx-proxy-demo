package com.mind.weixin.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by serv on 2015/1/31.
 */
public class UserGetCardEvent extends UserDelCardEvent {

    @JacksonXmlProperty(localName = "IsGiveByFriend")
    protected String isGiveByFriend;

    @JacksonXmlProperty(localName = "FriendUserName")
    protected String friendUserName;

    @JacksonXmlProperty(localName = "OuterId")
    protected String outerId;

    public String getIsGiveByFriend() {
        return isGiveByFriend;
    }

    public void setIsGiveByFriend(String isGiveByFriend) {
        this.isGiveByFriend = isGiveByFriend;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }
}
