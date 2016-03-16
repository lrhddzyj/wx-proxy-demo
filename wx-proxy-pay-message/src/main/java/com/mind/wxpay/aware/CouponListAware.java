package com.mind.wxpay.aware;

import com.mind.wxpay.response.Coupon;

import java.util.List;

/**
 * 包装现金券相关的多序列节点
 * Created by serv on 2015/1/26.
 */
public interface CouponListAware {

    public int getCouponCount();

    public void setCouponList(List<Coupon> couponList);

}
