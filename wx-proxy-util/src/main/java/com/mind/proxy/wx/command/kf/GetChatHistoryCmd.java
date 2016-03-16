package com.mind.proxy.wx.command.kf;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.vo.KfChatInfo;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2015/3/20.
 */
public class GetChatHistoryCmd extends WxJsonCommand {

    private List<KfChatInfo> chatInfoList;

    public GetChatHistoryCmd(Date startTime,Date endTime,String openId,int page,int pageSize) {
        super("getKfRecord");
        Long start = new DateTime(startTime).getMillis() / 1000;
        Long end = new DateTime(endTime).getMillis() / 1000;

        addVariable("start",start.toString());
        addVariable("end",end.toString());
        addVariable("openId",openId);
        addVariable("page",String.valueOf(page));
        addVariable("pageSize",String.valueOf(pageSize));

    }

    public GetChatHistoryCmd(Date startTime, Date endTime, int page, int pageSize) {
        super("getAllKfRecord");
        Long start = new DateTime(startTime).getMillis() / 1000;
        Long end = new DateTime(endTime).getMillis() / 1000;

        addVariable("start",start.toString());
        addVariable("end",end.toString());
        addVariable("page",String.valueOf(page));
        addVariable("pageSize",String.valueOf(pageSize));

    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        chatInfoList = JsonUtils.json2List(jsonNode.path("recordlist").toString(), KfChatInfo.class);
    }

    public List<KfChatInfo> getChatInfoList() {
        return chatInfoList;
    }
}
