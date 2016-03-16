package com.mind.weixin.pay.service;

import com.mind.httpclient.command.Executors;
import com.mind.proxy.wx.command.pay.QiyeTransfersCmd;
import com.mind.wxpay.WxPayException;
import com.mind.wxpay.request.QiyeTransfersRequest;
import com.mind.wxpay.response.QiyeTransfersResponse;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2015/5/7.
 */
@Service
public class QiyeTransfersServiceImpl implements QiyeTransfersService {
    @Override
    public QiyeTransfersResponse transfers(QiyeTransfersRequest request,String key,byte[] keyStore,String keyStorePwd) throws WxPayException {
        return Executors.build().exec(new QiyeTransfersCmd(request,key,keyStore,keyStorePwd)).getResponse();
        }
        }
