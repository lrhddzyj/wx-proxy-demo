package com.mind.proxy.wx.command.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.OpenIdSet;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by serv on 2015/3/17.
 */
public class GetAttentionOpenIdsCmd extends WxJsonCommand {

    private OpenIdSet openIdSet;

    public GetAttentionOpenIdsCmd(String nextOpenId) {
        super("getAttentionList");
        if(StringUtils.isEmpty(nextOpenId)){
            nextOpenId = "";
        }
        addVariable("nextOpenId",nextOpenId);
    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        openIdSet = new OpenIdSet();
        openIdSet.setCount(jsonNode.path("count").asInt());
        openIdSet.setTotal(jsonNode.path("total").asInt());
        openIdSet.setNextOpenId(jsonNode.path("next_openid").asText());

        if(jsonNode.path("count").asInt()>0){
            String[] currentAttentions = JsonUtils.json2Array(jsonNode.path("data").path("openid").toString(), String.class);
            Set<String> sets =  new HashSet<String>();
            sets.addAll(Arrays.asList(currentAttentions));
            openIdSet.setData(sets);
        }
    }

    public OpenIdSet getOpenIdSet() {
        return openIdSet;
    }
}
