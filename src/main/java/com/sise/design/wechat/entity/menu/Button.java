package com.sise.design.wechat.entity.menu;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/23 20:21
 * @Descript: TODO
 * @Version: 1.0
 */


public class Button {

    private String name;//菜单标题

    private String type;//菜单的响应动作类型

    private Button[] sub_button;

    public Button(Map map) {
        this.name       = (String)   map.get("name");
        this.type       = (String)   map.get("type");
        this.sub_button = (Button[]) map.get("sub_button");
    }

    public Button() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

}
