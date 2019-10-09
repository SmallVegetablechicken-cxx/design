package com.sise.design.wechat.entity.menu;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/23 20:24
 * @Descript: TODO
 * @Version: 1.0
 */


public class ClickButton extends Button{

    private String key;//菜单KEY值

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ClickButton(Map map) {
        super(map);
        this.key = (String) map.get("key");
    }

    public ClickButton() {

    }
}
