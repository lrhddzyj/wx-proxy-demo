package com.mind.proxy.wx.command;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.command.JacksonCommand;
import com.mind.httpclient.jackson.XmlUtils;
import com.mind.proxy.wx.utils.SignUtils;
import com.mind.wxpay.WxPayException;
import com.mind.wxpay.aware.CouponListAware;
import com.mind.wxpay.aware.RefundListAware;
import com.mind.wxpay.aware.SignPostAware;
import com.mind.wxpay.response.Coupon;
import com.mind.wxpay.response.Refund;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by serv on 2015/3/19.
 */
public class WxXmlCommand<T> extends JacksonCommand {

    private String key;
    private T result;

    public WxXmlCommand(String command,Object body,String key) {
        super(command);
        this.key = key;
        //请求签名
        wrapSign(body,key);
        addVariable("xml", XmlUtils.obj2String(body));
    }

    /**
     * 验证xml返回的错误码和签名校对
     * @param resultText
     * @return
     */
    @Override
    protected JsonNode wrap2JsonNode(String resultText) {
        JsonNode jsonNode = super.wrap2JsonNode(resultText);
        if(jsonNode.path("return_code").asText().equals("FAIL")){
            throw new WxPayException(1005,jsonNode.path("return_msg").asText());
        }
        //需要验证消息的正确性
        if(jsonNode.has("sign")){
            String sign = SignUtils.sign(jsonNode, key);
            if(!StringUtils.equals(sign, jsonNode.path("sign").asText())){
                throw new WxPayException(5000,"消息验证失败,请检查返回消息的正确性!");
            }
        }
        return jsonNode;
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        // 获取父类声明的泛型类
        Type type = getClass().getGenericSuperclass();
        Type[] trueType = ((ParameterizedType) type).getActualTypeArguments();
        Class<T> tClass =  (Class<T>) trueType[0];
        result = xml2Obj(jsonNode, resultText, tClass);
    }

    public T getResponse(){
        return result;
    }

    /**
     * 如果是需要签名则验证随机串并且生成签名
     * @param body 要签名的对象
     * @param key 秘钥
     */
    private void wrapSign(Object body,String key){
        //如果实现了SignPostAware,那么该对象则需要签名
        if(body instanceof SignPostAware){
            if(StringUtils.isEmpty(((SignPostAware) body).getNonceStr())){
                ((SignPostAware) body).setNonceStr(StringUtils.remove(UUID.randomUUID().toString(), "-"));
            }
            ((SignPostAware) body).setSign(SignUtils.sign(body, key));
        }

    }


    protected T xml2Obj(JsonNode jsonNode, String xmlContent, Class<T> tClass) {
        //先把其他字段赋予值
        T t = XmlUtils.xml2Obj(xmlContent, tClass);
        //添加代金券列表
        if(CouponListAware.class.isAssignableFrom(tClass)){
            CouponListAware couponListAware = (CouponListAware) t;
            List<Coupon> couponList = new ArrayList<Coupon>();
            int next = couponListAware.getCouponCount();
            while (next>0){
                //下标从0开始
                next --;
                Coupon cp = new Coupon();
                cp.setCouponBatchId(jsonNode.path("coupon_batch_id_" + next).asText());
                cp.setCouponFee(jsonNode.path("coupon_fee_" + next).asText());
                cp.setCouponId(jsonNode.path("coupon_id_" + next).asText());
                couponList.add(cp);
            }
            couponListAware.setCouponList(couponList);
        }

        //添加退款详情列表
        if(RefundListAware.class.isAssignableFrom(tClass)){
            RefundListAware refundListAware = (RefundListAware) t;
            List<Refund> refundList = new ArrayList<Refund>();
            int next = refundListAware.getRefundCount();
            while (next>0){
                //下标从0开始
                next --;
                Refund refund = new Refund();

                refund.setOutRefundNo(jsonNode.path("out_refund_no_" + next).asText());
                refund.setRefundId(jsonNode.path("refund_id_" + next).asText());
                refund.setRefundChannel(jsonNode.path("refund_channel_" + next).asText());
                refund.setRefundFee(jsonNode.path("refund_fee_" + next).asText());
                refund.setCouponRefundFee(jsonNode.path("coupon_refund_fee_" + next).asText());
                refund.setRefundStatus(jsonNode.path("refund_status_" + next).asText());
                refund.setCouponRefundCount(jsonNode.path("coupon_refund_count_" + next).asInt());
                List<Coupon> couponList = new ArrayList<Coupon>();
                int next_j = refund.getCouponRefundCount();
                while (next_j>0){
                    Coupon coupon = new Coupon();
                    coupon.setCouponBatchId(jsonNode.path("coupon_refund_batch_id_" + next + "_" + next_j).asText());
                    coupon.setCouponFee(jsonNode.path("coupon_refund_fee_" + next + "_" + next_j).asText());
                    coupon.setCouponId(jsonNode.path("coupon_refund_id_" + next + "_" + next_j).asText());
                    couponList.add(coupon);
                    next_j--;
                }
                refund.setCouponRefundList(couponList);
                refundList.add(refund);

            }
            refundListAware.setRefundList(refundList);
        }

        return t;
    }


    @Override
    protected void throwGlobException(Throwable e) {
        if(e instanceof WxPayException){
            throw (WxPayException)e;
        }else{
            throw new WxPayException(500,e.getMessage());
        }
    }


}
