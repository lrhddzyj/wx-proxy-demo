package com.mind.wxpay.aware;

/**
 * 实现了该接口的类,会在post提交之前,遍历所有的 jackson声明的字段
 * 并且字典排序进行 sign 加密,判断nonceStr是否为空，为空则加入随机串
 * Created by serv on 2014/8/19.
 */
public interface SignPostAware {

    public void setNonceStr(String nonceStr);

    public String getNonceStr();

    /**
     * 加密对象中的字段,并且设置sign
     * @param sign
     */
    public void setSign(String sign);

}
