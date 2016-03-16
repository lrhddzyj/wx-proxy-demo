package com.mind.proxy.wx.command.push;

import com.mind.httpclient.jackson.JsonUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.Article;

import java.util.List;

/**
 * Created by serv on 2015/3/18.
 */
public class SendArticlesMessageCmd extends WxJsonCommand {

    public SendArticlesMessageCmd(String openId, List<Article> articles) {
        super("sendArticlesMessage");
        if(articles!=null&&articles.size()>10){
            throw new WeiXinException(90003,"少发点吧,顶多10条!");
        }
        addVariable("openId",openId);
        addVariable("articles", JsonUtils.object2Json(articles));

    }


}
