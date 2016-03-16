package com.mind.proxy.wx.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.collect.Lists;
import com.mind.weixin.WeiXinException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by serv on 2014/8/20.
 */
public abstract class SignUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(SignUtils.class);


    protected SignUtils() {
    }



    /**
     * post消息给微信支付,需要填充加密sign
     *  根据一个类，字典排序其对应的 JacksonXmlProperty localName 字段， 并且拼接 key 然后加密返回signValue
     */
    public static String sign(Object obj,String key) {
        try{
            TreeMap<String,String> fieldMap = new TreeMap<String, String>();
            List<Field> declaredFields = ReflectionUtils.getAccessibleFields(obj);
            for(Field field : declaredFields){
//                field.setAccessible(true);
                JacksonXmlProperty annotation = field.getAnnotation(JacksonXmlProperty.class);
                if(annotation!=null&&field.get(obj)!=null){
                    fieldMap.put(annotation.localName(),field.get(obj).toString());// example: app_id : appId Field
                }
            }
            return encodeSign(fieldMap,key);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            throw new WeiXinException(1001,"加密sign出错!");
        }
    }

    /**
     * 解析微信的主动推送消息,获取sign进行验证
     *  根据一个jsonNode对象，字典排序其各个字段， 并且拼接 key 然后加密返回signValue
     */
    public static String sign(JsonNode jsonNode,String key) {
        try{
            TreeMap<String,String> fieldMap = new TreeMap<String, String>();
            Iterator<String> fields =  jsonNode.fieldNames();
            while(fields.hasNext()){
                String fieldName = fields.next();
                if(!jsonNode.path(fieldName).isNull()){//jsonNode 不为空 则放入待加密的map中
                    fieldMap.put(fieldName,jsonNode.path(fieldName).asText());
                }
            }
            return encodeSign(fieldMap,key);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            throw new WeiXinException(1001,"加密sign出错!");
        }
    }


    /**
     * sign 签名
     * @param map
     * @return
     */
    public static String encodeSign(SortedMap<String,String> map,String key){
        if(StringUtils.isEmpty(key)){
            throw new WeiXinException(007,"签名key不能为空");
        }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        List<String> values = Lists.newArrayList();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String k = String.valueOf(entry.getKey());
            String v = String.valueOf(entry.getValue());
            if (StringUtils.isNotEmpty(v)&& !"sign".equals(k)
                    && !"key".equals(k)) {
                values.add(k + "=" + v);
            }
        }
        values.add("key="+ key);
        LOGGER.debug("key:{}",key);
        String sign = StringUtils.join(values, "&");
        LOGGER.debug("stringSignTemp:{}",sign);
        return WxEncodeUtils.encodeByMD5(sign).toUpperCase();
    }

    /**
     * sign 签名
     * @param map
     * @return
     */
    public static String sha1(SortedMap<String,String> map){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        List<String> values = Lists.newArrayList();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            values.add((String) entry.getKey() + "=" + (String) entry.getValue());
        }
        String sign = StringUtils.join(values, "&");
        LOGGER.debug("stringSignTemp:{}",sign);
        return WxEncodeUtils.encodeSHA(sign);
    }

}
