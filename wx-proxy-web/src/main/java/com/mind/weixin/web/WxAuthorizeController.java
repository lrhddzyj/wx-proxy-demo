package com.mind.weixin.web;



import com.mind.config.service.WxConfigService;
import com.mind.config.vo.WxConfigVo;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.service.WxOauth2Service;
import com.mind.weixin.service.WxUserInfoRecordService;
import com.mind.weixin.vo.Oauth2Token;
import com.mind.weixin.vo.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
* Created by rocky on 14-7-28.
*/
@Controller
public class WxAuthorizeController{

    private static final Logger LOGGER = LoggerFactory.getLogger(WxAuthorizeController.class);

    private static final String SNSAPI_BASE = "snsapi_base";
    private static final String SNSAPI_USERINFO = "snsapi_userinfo";

    @Autowired
    private WxOauth2Service oauth2Service;
    @Autowired
    private WxConfigService wxConfigService;

    @Autowired
    private WxUserInfoRecordService wxUserInfoRecordService;

    @RequestMapping(value = "/oauth2/redirect" , method = RequestMethod.GET)
    public String snsapiBase(@RequestParam("code")String code ,
                             @RequestParam("url")String url ,
                             @RequestParam("appId")String appId ,
                             @RequestParam("scope")String scope ,
                             @RequestParam("state")String state
                             ){
        WxConfigVo configVo = wxConfigService.getWxConfigByAppId(appId);

        if(configVo==null){
            throw new WeiXinException(800,"没有配置微信appId:"+appId+" 对应的商家设置");
        }
//        if(WxConfigType.AUTHOR.equals(configVo.getConfigType())){
//            //授权模式
//            ThWxConfigVo thWxConfigVo = thApiService.getThWxConfigVo(configVo.getAuthorType());
//            String componentAppId = thWxConfigVo.getAppId();
//            String componentAccessToken = thApiService.getToken(configVo.getAuthorType());
//
//            Oauth2Token token = oauth2Service.getWebAccessTokenByCodeTh(componentAccessToken, appId, code, componentAppId);
//
//            url += url.contains("?")?"&openId="+token.getOpenId():"?openId="+token.getOpenId();
//            url += "&state="+state;
//            if(StringUtils.equals(scope,SNSAPI_BASE)){//基本授权,直接跳转
//                return "redirect:"+url;
//            }else if(StringUtils.equals(scope,SNSAPI_USERINFO)){//获取用户信息并保存到redis中
//                UserInfo userInfo = oauth2Service.getUserInfoTh(token.getAccessToken(), token.getOpenId());
//                userInfo.setAppId(appId);
//                wxUserInfoRecordService.saveUserInfo(userInfo);
//                LOGGER.info("snsapiBase:"+url);
//                return "redirect:"+url;
//            }
//        }else { //普通模式
            Oauth2Token token = oauth2Service.getWebAccessTokenByCode(appId, configVo.getWxAppSecret(), code);
            url += url.contains("?")?"&openId="+token.getOpenId():"?openId="+token.getOpenId();
            url += "&state="+state;
            if(StringUtils.equals(scope,SNSAPI_BASE)){//基本授权,直接跳转
                return "redirect:"+url;
            }else if(StringUtils.equals(scope,SNSAPI_USERINFO)){//获取用户信息并保存到mangodb中
                UserInfo userInfo = oauth2Service.getUserInfo(token.getAccessToken(), token.getOpenId());
                userInfo.setAppId(appId);
                wxUserInfoRecordService.saveUserInfo(userInfo);
                LOGGER.info(url);
                return "redirect:"+url;
            }
//        }
        return null;
    }


    /**
     * 该地址是所有需要微信授权的入口地址:
     * 示例1(基本授权,仅获取openId) : http://liuyh.ematong.com/oauth2?appId=wx8654c45a1beb6837&scope=snsapi_base&state=123&url=http://liuyh.ematong.com/test
     * 示例2(userinfo授权,获取用户信息) : http://liuyh.ematong.com/oauth2?appId=wx8654c45a1beb6837&scope=snsapi_userinfo&state=123&url=http://liuyh.ematong.com/test
     * 用户打开上述地址后,会跳转到微信进行授权,根据scope的作用域不同,来选择性的提示用户是否需要授权
     * 1. 基本授权: 打开url后,跳转到微信授权后,跳转回来获取到用户的openId
     * 2. userinfo授权: 打开url后,跳转到微信,用户界面弹出授权窗口,用户登录后,跳转回来.获取到用户的openId和用户信息(保存到record记录中)
     *
     * 转向业务url: 附带的参数有 openId 和 state .
     * 业务可以调用dubbo接口
     * WxUserInfoRecordService.getUserInfo(openId)
     * 方法.获取用户的详细信息.
     *
     * 注意: 该接口获取的用户信息包含有 createTime (记录的创建时间) ,业务可以在需要获取用户信息之前,先调用该接口获取下用户信息.
     * 1. 没有返回用户信息的情况下,表示需要走用户授权,获取一次
     * 2. 获取到的用户信息的createTime创建时间超过1/3个月(具体时间由业务判断),来选择性的是否需要用户授权
     * 3. 如果进行跳转前,获取到的用户信息是比较新的,故而可以省略url跳转这一步
     * @param appId 微信appId
     * @param scope 作用域 snsapi_userinfo or snsapi_base
     * @param url 业务url
     * @param state 一直附带的param参数
     * @return redirect_url
     */
    @RequestMapping(value = "/oauth2", method = RequestMethod.GET)
    public String forwordResult(@RequestParam("appId") String appId ,
                                @RequestParam("scope")String scope ,
                                @RequestParam("url")String url ,
                                @RequestParam(value = "state",required = false) String state,
                                HttpServletRequest request) throws UnsupportedEncodingException {


        WxConfigVo configVo = wxConfigService.getWxConfigByAppId(appId);
        if(configVo==null){
            throw new WeiXinException(800,"没有配置微信appId:"+appId+" 对应的商家设置");
        }
        String redirectUrl = "" ;
        int port = request.getServerPort();
        url = URLDecoder.decode(url,"UTF-8");
        url = url.replace("#rd","");
        url = URLEncoder.encode(url,"UTF-8");
        String proxyUrl = "http://"+request.getServerName()+(port==80?"":":"+port)+request.getContextPath()+"/oauth2/redirect?url="+url
                +"&scope="+scope
                +"&appId="+appId;

        proxyUrl = URLEncoder.encode(proxyUrl,"UTF-8") ;

//        if(WxConfigType.AUTHOR.equals(configVo.getConfigType())){
//            //授权模式
//            ThWxConfigVo thWxConfigVo = thApiService.getThWxConfigVo(configVo.getAuthorType());
//            redirectUrl = oauth2Service.getWxRedirectUrlTh(thWxConfigVo.getAppId(), appId, proxyUrl,scope,state);
//        }else {//普通模式
            redirectUrl = oauth2Service.getWxRedirectUrl(appId, proxyUrl, scope, state);
//        }

        return "redirect:"+ redirectUrl ;
    }


    @RequestMapping("/")
    public String index(){
        return "index";
    }


}
