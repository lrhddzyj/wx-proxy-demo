package com.mind.weixin.service;

import com.mind.config.vo.WxConfigVo;
import com.mind.proxy.wx.command.jsapi.GetSignatureMapCmd;
import com.mind.proxy.wx.command.jsapi.JsApiTicketCmd;
import com.mind.weixin.WeiXinException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by serv on 2015/1/19.
 */
@Service
public class WxJsapiServiceImpl extends BaseService implements WxJsapiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxJsapiServiceImpl.class);

    @Autowired
    StringRedisTemplate redisTemplate;

//    @Autowired
//    WxConfigService wxConfigService;

    /**
     * 包装ticket 如果有则复用,否则创建
     * @return
     */
    private String getTicket(String appId) {
        String ticket = "" ;
        if(redisTemplate.hasKey(JSAPI_TICKET_KEY_PREFIX+appId)){//如果存在ticket
            ticket = redisTemplate.boundValueOps(JSAPI_TICKET_KEY_PREFIX+appId).get();
            return ticket;
        }else{//创建token
            ticket = buildTicket(appId) ;
            return ticket;
        }
    }

    /**
     * 创建一个ticket,无论是否存在ticket
     * @return
     */
    private String buildTicket(String appId){
        WxConfigVo config = wxConfigService.getWxConfigByAppId(appId);

        String ticket;
        try{
//            //授权模式
//            if (WxConfigType.AUTHOR.equals(config.getConfigType())){
//                String wxAppAccessToken = thApiService.getWxAppAccessToken(config.getAuthorType(), appId);
//                ticket = execToken("TOKEN_"+wxAppAccessToken,new JsApiTicketCmd()).getTicket();
//            }else {
                ticket = execToken(appId, new JsApiTicketCmd()).getTicket();
//            }
            //TOKEN 的有效期是7200秒,这里设置为7000秒后自动清除,以方便获取新的token
            redisTemplate.boundValueOps(JSAPI_TICKET_KEY_PREFIX+appId).set(ticket, 7000, TimeUnit.SECONDS);
        }catch (Exception e){
            LOGGER.info("buildTicket异常：{}，appId：{}",e,appId);
            throw new WeiXinException(800,"获取jsapi-ticket失败");
        }
        return ticket;
    }


    @Override
    public Map<String, String> getJsapiMap(String wxAppId, String url) {
        LOGGER.info("buildTicket:getJsapiMap：wxAppId：{}，url{}",wxAppId,url);
        try{
            return exec(new GetSignatureMapCmd(getTicket(wxAppId), url)).getTreeMap();
        }catch (WeiXinException e){
            //如果出错，重新生成ticket然后重试
            return exec(new GetSignatureMapCmd(buildTicket(wxAppId), url)).getTreeMap();
        }
    }
}
