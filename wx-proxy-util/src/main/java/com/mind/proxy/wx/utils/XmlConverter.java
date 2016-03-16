package com.mind.proxy.wx.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.converter.AbstractXmlConverter;
import com.mind.httpclient.jackson.XmlUtils;
import com.mind.weixin.message.base.BaseMessage;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by serv on 2015/3/19.
 */
public class XmlConverter extends AbstractXmlConverter<BaseMessage> {

    private static Map<String,Class> types;

    static{
        types = new HashMap<String, Class>();
        try {
            InputStream resourceAsStream = XmlConverter.class.getClassLoader().getResourceAsStream("wx-proxy-message.xml");
            Map<String,String> maps = XmlUtils.stream2Obj(resourceAsStream, HashMap.class);
            Set<String> keySet = maps.keySet();
            for(String key:keySet){
                types.put(key, Class.forName(maps.get(key)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public XmlConverter() {
        super(types);
    }

    @Override
    protected Class getClass(JsonNode jsonNode, String xmlContent) {
        Class messageClass;
        if(jsonNode.path("MsgType").asText().equals("event")){
            messageClass = types.get("event."+jsonNode.path("Event").asText());
        }else{
            messageClass = types.get(jsonNode.path("MsgType").asText());
        }
        return messageClass;
    }
}
