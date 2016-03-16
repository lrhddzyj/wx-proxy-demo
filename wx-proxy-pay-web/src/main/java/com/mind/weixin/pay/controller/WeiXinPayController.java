package com.mind.weixin.pay.controller;

import com.mind.weixin.pay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by rocky on 14/12/25.
 */
@Controller
public class WeiXinPayController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping("/wxpay/{prepayId}")
    public String payPage(@PathVariable("prepayId")String prepayId , HttpServletRequest request) {
        try {
            Map<String, String> jsapi = transactionRepository.findByPrepayId(prepayId).getJsapi();
            request.setAttribute("jsapi" , jsapi);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "wxpay";
    }

}
