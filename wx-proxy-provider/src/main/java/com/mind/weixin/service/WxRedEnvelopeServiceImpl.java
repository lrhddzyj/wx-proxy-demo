package com.mind.weixin.service;

import com.mind.proxy.wx.command.red.RedEnvelopeCmd;
import com.mind.weixin.vo.RedEnvelope;
import org.springframework.stereotype.Service;

/**
 * Created by rocky on 14-7-28.
 * 微信红包功能
 */
@Service
public class WxRedEnvelopeServiceImpl extends BaseService implements WxRedEnvelopeService {


    @Override
    public Boolean sendRedEnvelope(RedEnvelope redEnvelope) {
        return exec(new RedEnvelopeCmd(redEnvelope)).isSuccess();
    }
}
