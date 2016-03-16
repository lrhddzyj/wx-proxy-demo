package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.RedEnvelope;

/**
 * Created by serv on 2014/7/29.
 */
public interface WxRedEnvelopeService {

    /**
     * 发红包接口
     * @param redEnvelope
     * @return
     */
    public Boolean sendRedEnvelope(RedEnvelope redEnvelope) throws WeiXinException;
}
