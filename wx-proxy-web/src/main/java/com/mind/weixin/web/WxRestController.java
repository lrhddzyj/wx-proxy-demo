package com.mind.weixin.web;


import com.mind.config.service.WxConfigService;
import com.mind.config.vo.WxConfigVo;
import com.mind.httpclient.jackson.XmlUtils;
import com.mind.proxy.wx.utils.WxEncodeUtils;
import com.mind.proxy.wx.utils.XmlConverter;
import com.mind.proxy.wx.utils.aes.AesException;
import com.mind.proxy.wx.utils.aes.WXBizMsgCrypt;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.command.WxCommand;
import com.mind.weixin.message.base.BaseMessage;
import com.mind.weixin.reply.BaseReplyMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


/**
 * Created by rocky on 2014/7/18.
 */
@RestController
@RequestMapping("weixin")
public class WxRestController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    WxConfigService wxConfigService;

    @Autowired
    WxCommand command;

    private XmlConverter xmlConverter = new XmlConverter();

    /**
     * 根据appId获取相关的配置
     * @param appId
     * @return
     */
    private WxConfigVo getWxConfigByAppId(String appId){
        WxConfigVo wxConfigVo = wxConfigService.getWxConfigByAppId(appId);
        if(wxConfigVo==null){
            throw new WeiXinException(800,"没有配置微信appId:"+appId+" 对应的商家设置");
        }
        return wxConfigVo;
    }

    /**
     * 首次认证
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/{appId}",method = RequestMethod.GET)
    public String weiXin(@PathVariable(value = "appId") String appId,
                         @RequestParam(value = "echostr")String echostr,
                         @RequestParam(value = "nonce") String nonce,
                         @RequestParam(value = "signature") String signature,
                         @RequestParam(value = "timestamp") String timestamp) {
        WxConfigVo configVo = getWxConfigByAppId(appId);
        String[] strArr = new String[] { configVo.getWxAppToken(), timestamp, nonce };
        Arrays.sort(strArr);
        if (signature.equals(WxEncodeUtils.encodeSHA(StringUtils.join(strArr)))){
            return echostr;
        }
        return "认证失败";
    }


    @RequestMapping(value = "/{appId}",method = RequestMethod.POST, produces = {"application/xml"})
    public String weixin(@PathVariable(value = "appId")String appId ,
                                     @RequestParam(value = "encrypt_type",required = false) String encryptType,
                                     @RequestParam(value = "msg_signature",required = false) String msgSignature,
                                     @RequestParam(value = "nonce") String nonce,
                                     @RequestParam(value = "signature") String signature,
                                     @RequestParam(value = "timestamp") String timestamp,
                            @RequestBody String xml) throws UnsupportedEncodingException, AesException {
        long startTime = System.currentTimeMillis();
        //不加密的时候 验证消息的正确性
        //加密的情况下,使用解密验证
        WXBizMsgCrypt wct = null;
        boolean messageEncrypted = StringUtils.equals(encryptType,"aes");
        WxConfigVo wxConfigVo = getWxConfigByAppId(appId);

        //如果采用了消息加密
        if(messageEncrypted){
            wct = new WXBizMsgCrypt(wxConfigVo.getWxAppToken(),wxConfigVo.getEncodingKey(),appId);
            xml = wct.decryptMsg(msgSignature, timestamp, nonce, xml);
        }else{
            //非加密消息传输,验证消息的来源
            String[] strArr = new String[] { wxConfigVo.getWxAppToken(), timestamp, nonce };
            Arrays.sort(strArr);
            if (!signature.equals(WxEncodeUtils.encodeSHA(StringUtils.join(strArr)))){
                throw new WeiXinException(645,"消息不是来自微信!");
            }
        }


        log.info("↓↓↓接收到消息:{}\n{}\n",appId,xml);
        final BaseMessage requestMessage = xmlConverter.converter(xml);
        requestMessage.setAppId(appId);
        //优先执行逻辑业务
        BaseReplyMessage responseMessage = command.execute(requestMessage);

        //不需要微信等待.直接返回""
        if(responseMessage==null){
            log.info("↑↑↑耗时:{}毫秒",System.currentTimeMillis()-startTime);
            return "";
        }

        //响应微信消息
        String responseBody = XmlUtils.obj2String(responseMessage);
        log.info("↑↑↑耗时:{}毫秒 响应消息: \n{}\n",System.currentTimeMillis()-startTime,responseBody);
        if(messageEncrypted){//加密消息
            responseBody = wct.encryptMsg(responseBody,timestamp,nonce);
        }
        return responseBody;
    }


}
