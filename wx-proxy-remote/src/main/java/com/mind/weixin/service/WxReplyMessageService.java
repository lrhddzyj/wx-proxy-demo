package com.mind.weixin.service;

import com.mind.weixin.message.base.BaseMessage;
import com.mind.weixin.reply.BaseReplyMessage;

/**
 * 微信响应回复消息接口,需要外部实现并提供服务
 * Created by serv on 2014/12/30.
 */
public interface WxReplyMessageService {

    /**
     * 收到微信的消息会同步调用该方法,由该方法同步返回响应消息给微信
     * @param message 微信发送给服务器的消息
     * @return 响应回复的消息
     */
    public BaseReplyMessage onMessage(BaseMessage message);

}
