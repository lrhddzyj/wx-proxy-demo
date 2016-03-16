package com.mind.weixin.command;

import com.mind.weixin.asyn.AsynExecutor;
import com.mind.weixin.message.base.BaseEventMessage;
import com.mind.weixin.message.base.BaseMessage;
import com.mind.weixin.reply.BaseReplyMessage;
import com.mind.weixin.service.WxReplyMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by serv on 2014/12/25.
 */
@Component
public class WxCommand {

    private Logger logger = LoggerFactory.getLogger(WxCommand.class);

    @Autowired
    EventCommand eventCommand;

    @Autowired
    MessageCommand messageCommand;

    @Autowired
    AsynExecutor asynExecutor;


    @Autowired
    WxReplyMessageService wxReplyMessageService;



    /**
     * 处理消息
     * @param message 消息
     * @return 响应给微信的回复消息
     */
    public BaseReplyMessage execute(final BaseMessage message) {
        BaseReplyMessage replyMessage = null;
        try{
            if(message instanceof BaseEventMessage){//事件
                eventCommand.execute((BaseEventMessage)message);
            }else if(message instanceof BaseMessage){//消息
                messageCommand.execute((BaseMessage)message);
            }
        }catch(Exception e){
            logger.error("weixin asyn error:"+e.getMessage());
        }

        //异步通知消息
        asynExecutor.sendMessage(message);
        //异步更新kissTime
        asynExecutor.updateKissTime(message);


        //调用同步响应的消息
        try{
            replyMessage = wxReplyMessageService.onMessage(message);
        }catch (Exception e){
            logger.error("weixin reply error:"+e.getMessage());
        }

        return replyMessage;
    }

}
