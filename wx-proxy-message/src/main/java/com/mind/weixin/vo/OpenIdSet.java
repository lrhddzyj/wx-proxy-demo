package com.mind.weixin.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by serv on 2015/1/7.
 */
public class OpenIdSet implements Serializable {
    /**
     * 关注该公众账号的总用户数
     */
    private Integer total;
    /**
     * 拉取的OPENID个数，最大值为10000
     */
    private Integer count;

    /**
     * 拉取列表的后一个用户的OPENID
     */
    private String nextOpenId;
    /**
     * 列表数据，OPENID的列表
     */
    private Set<String> data = new HashSet<String>();

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }
}
