package com.mind.proxy.wx.command.red;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.mind.httpclient.command.FormCommand;
import com.mind.proxy.wx.utils.SignUtils;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.RedEnvelope;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by serv on 2015/3/20.
 */
public class RedEnvelopeCmd extends FormCommand {

    private RedEnvelope redEnvelope;

    private boolean success;

    public RedEnvelopeCmd(RedEnvelope redEnvelope) {
        super("redEnvelope");
        this.redEnvelope = redEnvelope;
    }

    @Override
    protected Map<String, String> getFormVariables() {
        SortedMap<String,String> fieldValueMap = Maps.newTreeMap();
        //拼装传输过来的对象的field信息.组装成参数串
        for (Field field : redEnvelope.getClass().getDeclaredFields()){
            JsonProperty annotation = field.getAnnotation(JsonProperty.class);
            if(annotation!=null){
                Object fieldValue = invokeGetMethod(redEnvelope,field.getName());
                if(fieldValue!=null){
                    fieldValueMap.put(annotation.value().equals("") ? field.getName() : annotation.value()
                            , fieldValue.toString());
                }
            }
        }

        //参数串补齐
        fieldValueMap.put("sp_billno",redEnvelope.getSpid()+ new DateTime(new Date()).toString("yyyyMMdd")+ RandomUtils.nextLong(1000000000L,9999999999L));
        fieldValueMap.put("input_charset","utf-8");
        fieldValueMap.put("client_ip","127.0.0.1");

        String sign = SignUtils.encodeSign(fieldValueMap, redEnvelope.getKey());
        //md5参数串. 构造 getJson param
        fieldValueMap.put("sign",sign);
        return fieldValueMap;
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        success = jsonNode.path("retcode").asInt()==0;
    }

    private Object invokeGetMethod(Object targetObj , String fieldName){
        // 将属性的首字符大写，方便构造get，set方法
        String name = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        try {
            Method method = targetObj.getClass().getMethod("get" + name);
            return method.invoke(targetObj);
        } catch (Exception e) {
            throw new WeiXinException(90005,"转换RedEnvelope出错"+e.getMessage());
        }
    }


    public boolean isSuccess() {
        return success;
    }
}
