package com.mind.weixin.pay.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Created by serv on 2015/1/10.
 */
@Service
public class MessageService {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Async
    public void send(String exchange,String routingKey,Object object, final Map header, final long expires){
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
