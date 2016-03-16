package com.mind.wxpay.aware;

/**
 * Created by serv on 2015/3/24.
 */
public interface JsApiOpenIdAware {

    public void setSubOpenId(String subOpenId);
    public void setOpenId(String openId);
    public String getOpenId();
    public String getSubMchId();
}
