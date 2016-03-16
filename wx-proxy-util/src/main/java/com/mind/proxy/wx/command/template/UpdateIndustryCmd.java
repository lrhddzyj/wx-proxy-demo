package com.mind.proxy.wx.command.template;

import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class UpdateIndustryCmd extends WxJsonCommand {

    public UpdateIndustryCmd(Integer masterIndustryId,Integer subIndustryId) {
        super("api_set_industry");
        addVariable("masterIndustryId", masterIndustryId.toString());
        addVariable("subIndustryId",subIndustryId.toString());
    }

}
