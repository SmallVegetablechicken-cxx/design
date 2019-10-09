package com.sise.design.wechat.entity.message;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author:     Chen xuexin
 * @Time:      2019/7/15 23:23
 * @Descript:  TODO
 * @Version:   1.0
 */

@Component
public class NewsArticle {
    // 图文消息名称
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return null == Description ? "" : Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return null == PicUrl ? "" : PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return null == Url ? "" : Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public NewsArticle(Map map){
        Title       = (String) map.get("Title");
        Description = (String) map.get("Description");
        PicUrl      = (String) map.get("PicUrl");
        Url         = (String) map.get("Url");
    }

    public NewsArticle(){

    }
}

