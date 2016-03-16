package com.mind.wxpay.aware;

import com.mind.wxpay.response.Refund;

import java.util.List;

/**
 * 包装退款相关的多序列节点
 * Created by serv on 2015/1/26.
 */
public interface RefundListAware {

    public int getRefundCount();

    public void setRefundList(List<Refund> refundList);
    
}
