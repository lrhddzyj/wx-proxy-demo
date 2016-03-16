package com.mind.weixin.jmx;

import com.mind.weixin.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2015/6/20.
 */
@Service
@ManagedResource(currencyTimeLimit = 20)
@Lazy
public class WxProxyJmxManagement implements Constants{

    @Autowired
    StringRedisTemplate redisTemplate;

    @ManagedOperation(description = "重置appId对应的卡券的CARD_JSAPI_TICKET")
    @ManagedOperationParameters(
            @ManagedOperationParameter(name = "appId", description = "公众号appId")
    )
    public void resetCardJsApiTicket(String appId){
        redisTemplate.delete(WX_CARD_JSAPI_TICKET_KEY_PREFIX+appId);
    }

    @ManagedOperation(description = "重置appId对应的ACCESSTOKEN")
    @ManagedOperationParameters(
            @ManagedOperationParameter(name = "appId", description = "公众号appId")
    )
    public void resetAccessToken(String appId){
        redisTemplate.delete(ACCESSTOKEN_KEY_PREFIX +appId);
    }

    @ManagedOperation(description = "重置appId对应的JSAPI_TICKET")
    @ManagedOperationParameters(
            @ManagedOperationParameter(name = "appId", description = "公众号appId")
    )
    public void resetJsApiTicket(String appId){
        redisTemplate.delete(JSAPI_TICKET_KEY_PREFIX +appId);
    }
}
