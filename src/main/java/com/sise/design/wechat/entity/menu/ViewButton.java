package com.sise.design.wechat.entity.menu;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/23 20:26
 * @Descript: TODO
 * @Version: 1.0
 */



public class ViewButton extends Button{

    private String url;//网页链接

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ViewButton(Map map) {
        super(map);
        this.url= (String) map.get("url");
    }

    public ViewButton() {

    }
}
