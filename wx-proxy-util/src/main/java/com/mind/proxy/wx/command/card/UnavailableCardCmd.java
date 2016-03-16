package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by user on 2015/7/1.
 */
public class UnavailableCardCmd extends WxJsonCommand {

    public UnavailableCardCmd(String code,String cardId) {
        super("unavailableCard");

        StringBuffer json = new StringBuffer("\"code\": \""+code+"\"") ;
        if(StringUtils.isNotEmpty(cardId)){
            json.append(",\"card_id\": \""+cardId+"\"");
        }
        addVariable("json",json.toString());
    }
}
