package com.sise.design.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.sise.design.general.util.web.HttpUtil;
import com.sise.design.wechat.entity.menu.Button;
import com.sise.design.wechat.entity.menu.ClickButton;
import com.sise.design.wechat.entity.menu.Menu;
import com.sise.design.wechat.entity.menu.ViewButton;

import java.util.HashMap;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/23 20:30
 * @Descript: TODO
 * @Version: 1.0
 */


public class MenuUtil {

    private static final String CREATE_MENU_URL  = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 创建菜单
     * @param menu 菜单json格式字符串
     * @return int
     */
    public static int createMenu(String menu){
        int result = Integer.MIN_VALUE;
        String url = CREATE_MENU_URL.replaceAll("ACCESS_TOKEN", AccessTokenUtil.getAccessToken());
        HashMap<String, Object> map = new HashMap<>();
        map.put("",menu);
        String jsonStr = HttpUtil.httpPost(url, map);
        if(jsonStr!=null){
            //从返回的数据包中取数据{"errcode":0,"errmsg":"ok"}
            result = JSONObject.parseObject(jsonStr).getInteger("errcode");
        }
        return result;
    }

    public static String initMenu(){
        //创建点击一级菜单
        ClickButton button11 = new ClickButton();
        button11.setName("往期活动");
        button11.setKey("11");
        button11.setType("click");

        //创建跳转型一级菜单
        ViewButton button21 = new ViewButton();
        button21.setName("百度一下");
        button21.setType("view");
        button21.setUrl("https://www.baidu.com");

        //创建其他类型的菜单与click型用法一致
        ClickButton button31 = new ClickButton();
        button31.setName("拍照发图");
        button31.setType("pic_photo_or_album");
        button31.setKey("31");

        ClickButton button32 = new ClickButton();
        button32.setName("发送位置");
        button32.setKey("32");
        button32.setType("location_select");

        //封装到一级菜单
        Button button = new Button();
        button.setName("菜单");
        button.setType("click");
        button.setSub_button(new Button[]{button31,button32});

        //封装菜单
        Menu menu = new Menu();
        menu.setButton(new Button[]{button11,button21,button});
        return JSONObject.toJSONString(menu);
    }
}

