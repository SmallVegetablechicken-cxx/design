package com.sise.design.wechat.util;

import com.sise.design.wechat.config.until.WeChatConfigReadUtil;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * user:      Chen xuexin
 * Time:      2019/7/15 0:15
 * Class:     WeixinCheckUtil
 * Descript:  TODO
 * Version:   1.0
 */


public class WeChatCheckUtil {

    private static final String TOKEN = WeChatConfigReadUtil.getToken();

    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] str = new String[]{TOKEN,timestamp,nonce};
        //排序
        Arrays.sort(str);
        //拼接字符串
        StringBuilder builder = new StringBuilder();
        for(String str2 : str){
            builder.append(str2);
        }
        //进行sha1加密
        String temp = SHA1.encode(builder.toString());
        //与微信提供的signature进行匹对
        return signature.equals(temp);
    }
}
