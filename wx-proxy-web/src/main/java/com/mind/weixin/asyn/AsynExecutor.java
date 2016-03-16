package com.mind.weixin.asyn;

import com.mind.weixin.message.StatusEvent;
import com.mind.weixin.message.base.BaseEventMessage;
import com.mind.weixin.message.base.BaseMessage;
import com.mind.weixin.service.WxUserInfoRecordService;
import org.joda.time.DateTime;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by serv on 2014/12/25.
 */
@Service
public class AsynExecutor {

    final static String EXCHANGE = "o2o.weixin";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private WxUserInfoRecordService wxUserInfoRecordService;


    @Async
    public void sendMessage(BaseMessage message) {
        Map<String,Object> messageHeader = new HashMap<String, Object>();
        messageHeader.put("appId", message.getAppId());
        messageHeader.put("msgType",message.getMsgType());
        messageHeader.put("fromUserName",message.getFromUserName());
        messageHeader.put("toUserName",message.getToUserName());

        String bindingKey = "";

        if(message instanceof BaseEventMessage){
            bindingKey = EXCHANGE+".event."+((BaseEventMessage) message).getEvent();
        }else{
            bindingKey = EXCHANGE+"."+message.getMsgType();
        }
        send(EXCHANGE,bindingKey, message, messageHeader, 0L);

    }

    @Async
    public void updateKissTime(BaseMessage message){

        //模板消息事件推送不更新kisstime
        if(message instanceof StatusEvent ){
            if(((StatusEvent) message).getEvent().equals("TEMPLATESEND34JOBFINISH")){
                return;
            }
        }
        wxUserInfoRecordService.updateKissTime(message.getAppId(), message.getFromUserName(), DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        Map map = new HashMap();
        map.put("wxOpenId",message.getFromUserName());
        map.put("wxAppId",message.getAppId());
        map.put("activationTime",DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        send("o2o", "o2o.Activation.FS",map,map,0L);
    }



    private void send(String exchange,String routingKey,Object object, final Map header, final long expires){
        rabbitTemplate.convertAndSend(exchange,routingKey,object,new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                if(expires>0L){
                    message.getMessageProperties().setExpiration(String.valueOf(expires));
                }
                if(header!=null){
                    Set<String> set = header.keySet();
                    for(String key : set){
                        message.getMessageProperties().setHeader(key,header.get(key));
                    }
                }

                return message;
            }
        });
    }





}
