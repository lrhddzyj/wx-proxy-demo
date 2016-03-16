package com.mind.weixin.pay.service;

import com.mind.wxpay.WxPayException;
import com.mind.wxpay.request.QiyeTransfersRequest;
import com.mind.wxpay.response.QiyeTransfersResponse;

/**
 * Created by serv on 2015/5/7.
 */
public interface QiyeTransfersService {

    /**
     * 付款给用户
     * @param request 请求
     * @param key 签名秘钥
     * @param keyStore 证书
     * @param keyStorePwd 证书密码
     * @return
     * @throws WxPayException
     */
    public QiyeTransfersResponse transfers(QiyeTransfersRequest request, String key, byte[] keyStore, String keyStorePwd) throws WxPayException;
}
