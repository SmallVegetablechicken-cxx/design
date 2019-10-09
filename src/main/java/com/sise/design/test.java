package com.sise.design;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/8/21 19:05
 * @Descript: TODO
 * @Version: 1.0
 */

public class test {

    public static void main(String [] args){
//        Calendar c = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c.setTimeInMillis(System.currentTimeMillis());
//        c2.setTimeInMillis(System.currentTimeMillis());
//        c2.add(Calendar.YEAR,2);
//        System.out.println(c.getTime().after(c2.getTime()));

        String[][] str = new String[10][10];
        str[0][0]="1";
        str[0][1]="2";
        str[1][1]="2";
        str[1][0]="1";
        str[1][2]="";
        List map = new LinkedList<Map>();

        for(String[] str2 :str){
            int i2=0;
            HashMap map2=new HashMap();
            for(String str3:str2){
                map2.put("test"+i2,str3);
                i2++;
            }
            map.add(map2);

        }
        System.out.println(JSON.toJSON(map));
    }
}