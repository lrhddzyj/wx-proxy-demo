package com.mind.proxy.wx.command.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.proxy.wx.command.WxJsonCommand;

/**
 * Created by serv on 2015/3/18.
 */
public class AddTemplateCmd extends WxJsonCommand {

    private String templateId;

    public AddTemplateCmd(String templateCode) {
        super("api_add_template");
        addVariable("templateCode",templateCode);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        templateId = jsonNode.path("template_id").asText();
    }

    public String getTemplateId() {
        return templateId;
    }
}
