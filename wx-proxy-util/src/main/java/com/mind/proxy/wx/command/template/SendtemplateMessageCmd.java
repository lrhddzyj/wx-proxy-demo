package com.mind.proxy.wx.command.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.WxField;
import org.apache.http.util.Asserts;

import java.util.Map;

/**
 * Created by serv on 2015/3/18.
 */
public class SendtemplateMessageCmd extends WxJsonCommand {

    private String messageId;

    public SendtemplateMessageCmd(String openId,String templateId,String url,String topColor,Map<String, WxField> data) {
        super("templateMessage");
        Asserts.notNull(data, "模板内容");
        addVariable("openId", openId);
        addVariable("templateId", templateId);
        addVariable("url", url);
        addVariable("topColor", topColor);
        addVariable("data", JsonUtils.object2Json(data));
    }
    public SendtemplateMessageCmd(String openId,String templateId,String topColor,Map<String, WxField> data) {
        super("templateMessageNoUrl");
        Asserts.notNull(data, "模板内容");
        addVariable("openId", openId);
        addVariable("templateId", templateId);
        addVariable("topColor", topColor);
        addVariable("data", JsonUtils.object2Json(data));
    }



    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        messageId = jsonNode.path("msgid").asText();
    }

    public String getMessageId() {
        return messageId;
    }
}
