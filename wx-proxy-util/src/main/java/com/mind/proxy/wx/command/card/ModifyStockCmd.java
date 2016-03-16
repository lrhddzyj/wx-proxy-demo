package com.mind.proxy.wx.command.card;

import com.mind.proxy.wx.command.WxJsonCommand;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by user on 2015/7/1.
 */
public class ModifyStockCmd extends WxJsonCommand {

    public ModifyStockCmd(String cardId,String reduceStockValue,String increaseStockValue) {
        super("modifyStock");

        StringBuffer json = new StringBuffer("\"card_id\":\""+cardId+"\"") ;
        if(StringUtils.isNotEmpty(reduceStockValue)){
            json.append(",\"reduce_stock_value\":"+reduceStockValue) ;
        }
        if(StringUtils.isNotEmpty(increaseStockValue)){
            json.append( ",\"increase_stock_value\":"+increaseStockValue) ;
        }
        addVariable("json",json.toString());
    }
}
