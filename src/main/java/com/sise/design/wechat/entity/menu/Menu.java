package com.sise.design.wechat.entity.menu;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/23 20:28
 * @Descript: TODO
 * @Version: 1.0
 */


public class Menu {

    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }

    public Menu(Button[] button) {
        this.button = button;
    }

    public Menu() {
    }
}

