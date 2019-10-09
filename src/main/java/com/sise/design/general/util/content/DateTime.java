package com.sise.design.general.util.content;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/20 22:07
 * @Descript: TODO
 * @Version: 1.0
 */

public class DateTime {

    public static boolean compareDateTime(String data1 , String data2){
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date dt1 =  dt.parse(data1);
            Date dt2 =  dt.parse(data2);
            if(dt1.after(dt2)){
                return true;
            }
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean compareDateTime(String data ){
        return compareDateTime(data,getDateTime());
    }

    public static String getDateTime(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
       return dt.format(new Date());
    }

    public static String getFileNameDateTime(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddHHmmss");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getDate(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getTime(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getYear(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("yyyy");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getMonth(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("MM");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getDay(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("dd");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getHour(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("HH");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getMinute(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("mm");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }

    public static String getSecond(){
        //设置日期格式
        SimpleDateFormat dt = new SimpleDateFormat("ss");
        // new Date()为获取当前系统时间
        return dt.format(new Date());
    }
}
