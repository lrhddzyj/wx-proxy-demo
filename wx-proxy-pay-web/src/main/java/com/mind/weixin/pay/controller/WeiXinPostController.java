package com.mind.weixin.pay.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.common.collect.ImmutableMap;
import com.mind.httpclient.jackson.XmlUtils;
import com.mind.weixin.pay.WxPayConstants;
import com.mind.weixin.pay.service.MessageService;
import com.mind.weixin.pay.service.WxPaymentServiceImpl;
import com.mind.weixin.pay.utils.BeanMapper;
import com.mind.weixin.pay.vo.Transaction;
import com.mind.wxpay.response.NotifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serv on 2014/8/20.
 */
@RestController
public class WeiXinPostController {

    private Logger log = LoggerFactory.getLogger(WeiXinPostController.class);

    @Autowired
    WxPaymentServiceImpl wxPaymentService;

    @Autowired
    MessageService messageService;

    @Autowired
    BeanMapper beanMapper;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 支付完成后的微信通知url
     */
    @RequestMapping(value = "/notify", method = RequestMethod.POST,produces = "application/xml")
    public Result notify(@RequestBody String xml) {
        try {
            log.debug("接收到微信的推送:\n{}", xml);
            NotifyResponse postPaymentMessage = XmlUtils.xml2Obj(xml, NotifyResponse.class);
            Transaction transaction = wxPaymentService.getTransactionByOutTradeNo(postPaymentMessage.getOutTradeNo());
            messageService.send(WxPayConstants.EXCHANGE, WxPayConstants.ROUTING_KEY + transaction.getAppCode(),
                    transaction,
                    ImmutableMap.of("appCode", transaction.getAppCode(), "outTradeNo", transaction.getOutTradeNo()), 0L);
            return new Result("SUCCESS", "OK");
        } catch (Exception e) {
            return new Result("FAIL", e.getMessage());
        }
    }


    /**
     * 报警接口
     */
    @RequestMapping(value = "/exception")
    public Result exception(@RequestBody String xml) {
        try {
            log.debug("exception:\n{}", xml);
            mongoTemplate.save(xml,"exception");
            return new Result("SUCCESS", "OK");
        } catch (Exception e) {
            return new Result("FAIL", e.getMessage());
        }
    }



    /**
     * 商户处理后同步返回给微信(xml)的消息
     * Created by serv on 2014/8/15.
     */
    @JacksonXmlRootElement(localName = "xml")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private class Result {

        /**
         * 返回状态码
         */
        @JacksonXmlProperty(localName = "return_code")
        private String returnCode;

        /**
         * 返回信息
         */
        @JacksonXmlProperty(localName = "return_msg")
        private String returnMsg;

        public Result() {
        }

        public Result(String returnCode, String returnMsg) {
            this.returnCode = returnCode;
            this.returnMsg = returnMsg;
        }

        public String getReturnCode() {
            return returnCode;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }
    }
}
