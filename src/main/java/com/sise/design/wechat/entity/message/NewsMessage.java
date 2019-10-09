package com.sise.design.wechat.entity.message;

import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author:    Chen xuexin
 * @Time:      2019/7/15 23:18
 * @Descript:  TODO
 * @Version:   1.0
 */

@Component
public class NewsMessage extends BaseMessage {

    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<NewsArticle> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<NewsArticle> getArticles() {
        return Articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        Articles = articles;
    }

    public NewsMessage(Map map){
        super(map);
        MsgType           =                     MessageUtil.NEWS;
        this.ArticleCount = (int)               map.get("ArticleCount");
        this.Articles     = (List<NewsArticle>) map.get("Articles");
    }

    public NewsMessage(){

    }
}

