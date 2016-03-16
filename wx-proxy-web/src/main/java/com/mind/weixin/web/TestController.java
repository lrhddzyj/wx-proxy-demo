package com.mind.weixin.web;

import com.mind.httpclient.jackson.XmlUtils;
import com.mind.weixin.message.TextMessage;
import com.mind.weixin.service.WxUserInfoRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by serv on 2014/7/24.
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WxUserInfoRecordService wxUserInfoRecordService;

    @RequestMapping(value = "/test",produces = {"application/xml"})
    public String test(HttpServletRequest request) throws InterruptedException {
        logger.info(request.toString());
        //给压力测试用
        Thread.sleep(1000);
        TextMessage textMessage = new TextMessage();
        textMessage.setContent("回复给你的消息...");
        textMessage.setFromUserName("ff");
        textMessage.setToUserName("fsdf");
        textMessage.setCreateTime(System.currentTimeMillis());
//        System.out.println(converter.getClass());

        String responseBody = XmlUtils.obj2String(textMessage);
        return responseBody;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request){
        System.out.println(request.getParameterMap());
        return "success";
    }

    @RequestMapping(value = "/forword")
    public String valid(){
        return "wx-forward";
    }

    @RequestMapping(value = "/json")
    public TextMessage json(@RequestBody String body){
        System.out.println(body);
        TextMessage textMessage = new TextMessage();
        textMessage.setContent("回复给你的消息...");
        textMessage.setFromUserName("ff");
        textMessage.setToUserName("fsdf");
        textMessage.setCreateTime(System.currentTimeMillis());
//        System.out.println(converter.getClass());
        return textMessage;
    }

    @RequestMapping("/charset/{name}")
    public String charset(@PathVariable("name")String name){
        System.out.println(name);
        return name;
    }
}
