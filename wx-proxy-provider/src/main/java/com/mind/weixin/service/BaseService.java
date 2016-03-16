package com.mind.weixin.service;


import com.mind.config.service.WxConfigService;
import com.mind.config.vo.WxConfigVo;

import com.mind.httpclient.command.Command;
import com.mind.httpclient.command.Executors;
import com.mind.httpclient.command.JacksonCommand;
import com.mind.proxy.wx.command.token.AccessTokenCmd;
import com.mind.weixin.Constants;
import com.mind.weixin.WeiXinException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by serv on 2015/3/21.
 */
public abstract class BaseService implements Constants{

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    WxConfigService wxConfigService;

    @Autowired
    StringRedisTemplate redisTemplate;

    protected  <T extends JacksonCommand> T execToken(String wxAppId,T command){

        String accessToken;
        if(wxAppId==null){
            throw new WeiXinException(957,"wxAppId参数不能为空");
        }
        if(wxAppId.startsWith("TOKEN_")){
            accessToken = wxAppId.replace("TOKEN_","");
        }else{
            accessToken = getToken(wxAppId);
        }
        Executors.ExecutorBuilder builder = Executors.build().addVariable("accessToken",accessToken);
        try{
            return builder.exec(command);
        }catch (WeiXinException e){
            if(e.getErrorCode()==40001){//令牌失效,则重试一次
                builder.addVariable("accessToken",buildToken(wxAppId));
                return builder.exec(command);
            }
            if(e.getErrorCode()==45015){
                //容错,超出48小时回复时效
                return null;
            }
            throw e;
        }
    }
    protected <T extends Command> T exec(T command){
        Executors.build().exec(command);
        return command;
    }


    /**
     * 包装token 如果有则复用,否则创建
     * @param appId
     * @return
     */
    public String getToken(String appId) {
        if(redisTemplate.hasKey(ACCESSTOKEN_KEY_PREFIX +appId)){//如果存在token
            String token = redisTemplate.boundValueOps(ACCESSTOKEN_KEY_PREFIX +appId).get();
            return token;
        }else{//创建token
            return buildToken(appId);
        }
    }


    /**
     * 创建一个token,无论是否存在token
     * @param appId
     * @return
     */
    public String buildToken(String appId ) {

        WxConfigVo config = wxConfigService.getWxConfigByAppId(appId);
        if (config == null) {
            throw new WeiXinException(404, "appId:[" + appId + "]没有对应的微信配置");
        }

        //授权模式
//        if (WxConfigType.AUTHOR.equals(config.getConfigType())) {
//            try {
//                //此token在第三方开放平台已经维护在redis中，顾不需要再次维护
//                String wxAppAccessToken = thApiService.getWxAppAccessToken(config.getAuthorType(), appId);
//                return wxAppAccessToken ;
//            } catch (Exception e) {
//                LOGGER.info("授权方式获得到的wxAppAccessToken异常：{}，appId：{}",e,appId);
//                throw new WeiXinException(500, "获取授权配置信息失败，请检查是否已经授权。");
//            }
//        } else {//普通模式
            try {
                AccessTokenCmd tokenCmd = new AccessTokenCmd(appId, config.getWxAppSecret());
                String accessToken = exec(tokenCmd).getAccessToken();
                //TOKEN 的有效期是7200秒,这里设置为7000秒后自动清除,以方便获取新的token
                redisTemplate.boundValueOps(ACCESSTOKEN_KEY_PREFIX + appId).set(accessToken, 7000, TimeUnit.SECONDS);
                return accessToken;
            } catch (Exception e) {
                LOGGER.info("普通方式获得到的accessToken异常：{}，appId：{}",e,appId);
                throw new WeiXinException(500, "获取token失败,检查appId和秘钥是否正确");
            }
//        }
    }
}
