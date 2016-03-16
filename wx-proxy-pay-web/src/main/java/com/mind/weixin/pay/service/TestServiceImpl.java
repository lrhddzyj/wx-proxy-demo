package com.mind.weixin.pay.service;

import com.mind.config.service.WxConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lrh on 2015/12/16.
 */
@Service
public class TestServiceImpl {

    @Autowired
    WxConfigService wxConfigService;

    public void test() {
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println(wxConfigService.getWxConfigByAppId("1"));
    }

}
