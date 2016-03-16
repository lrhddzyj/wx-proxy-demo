package com.mind.weixin.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mind.weixin.reply.node.NewsItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by serv on 2014/8/5.
 */
public class NewsReplyMessage extends BaseReplyMessage{

    @JacksonXmlElementWrapper(localName = "Articles")
    @JacksonXmlProperty(localName = "item")
    private List<NewsItem> items = new ArrayList<NewsItem>();

    @JacksonXmlProperty(localName = "ArticleCount")
    private Integer articleCount;

    @Override
    public String initType() {
        return "news";
    }

    public List<NewsItem> getItems() {
        return items;
    }

    public void setItems(List<NewsItem> items) {
        this.items = items;
    }

    public void addItem(NewsItem item) {
        this.items.add(item);
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
