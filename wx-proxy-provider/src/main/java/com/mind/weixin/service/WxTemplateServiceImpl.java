package com.mind.weixin.service;

import com.mind.proxy.wx.command.template.AddTemplateCmd;
import com.mind.proxy.wx.command.template.SendtemplateMessageCmd;
import com.mind.proxy.wx.command.template.UpdateIndustryCmd;
import com.mind.weixin.vo.WxField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by serv on 2014/12/30.
 */
@Service
public class WxTemplateServiceImpl extends BaseService implements WxTemplateService{
    @Override
    public String sendtemplateMessage(String wxAppId, String toUserOpenId, String templateId, String url, String topColor, Map<String, WxField> data) {
        if(StringUtils.isEmpty(url)){
            return execToken(wxAppId,new SendtemplateMessageCmd(toUserOpenId,templateId,topColor,data)).getMessageId();
        }else{
            return execToken(wxAppId,new SendtemplateMessageCmd(toUserOpenId,templateId,url,topColor,data)).getMessageId();
        }

    }

    @Override
    public void updateIndustry(String wxAppId, Integer masterIndustryId, Integer subIndustryId) {
        execToken(wxAppId,new UpdateIndustryCmd(masterIndustryId,subIndustryId));
    }

    @Override
    public String addTemplate(String wxAppId, String templateCode) {
        return execToken(wxAppId,new AddTemplateCmd(templateCode)).getTemplateId();
    }
}
