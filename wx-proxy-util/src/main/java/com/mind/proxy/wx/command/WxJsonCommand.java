package com.mind.proxy.wx.command;

import com.fasterxml.jackson.databind.JsonNode;

import com.mind.httpclient.command.JacksonCommand;
import com.mind.weixin.WeiXinException;

/**
 * Created by serv on 2015/3/16.
 */
public abstract class WxJsonCommand extends JacksonCommand {


    public WxJsonCommand(String command) {
        super(command);
    }

    /**
     * 验证公众平台错误码
     * @param resultText
     * @return
     */
    @Override
    protected JsonNode wrap2JsonNode(String resultText) {
        JsonNode jsonNode = super.wrap2JsonNode(resultText);
        if(jsonNode.has("errcode")){
            int errCode = jsonNode.path("errcode").asInt();
            if (errCode!=0){
                String errMsg = jsonNode.path("errmsg").asText();
                log.info("调用微信服务发生错误,错误代码: {} 错误信息: {}", errCode,errMsg);
                throw new WeiXinException(errCode,errMsg);
            }
        }
        return jsonNode;
    }


    @Override
    protected void throwGlobException(Throwable e) {
        if(e instanceof WeiXinException){
            throw (WeiXinException)e;
        }else{
            throw new WeiXinException(500,e.getMessage());
        }
    }


}
