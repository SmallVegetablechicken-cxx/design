package com.sise.design.admin.service;

import com.sise.design.general.util.web.HttpUtil;
import com.sise.design.wechat.util.SHA1;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/2 11:29
 * @Descript: TODO
 * @Version: 1.0
 */

@Service("Admin_WeiXinService")
public class WeiXinService {

    public static String testServer(String url ,String token ,String xml){
        String value;
        if(xml!=null){
            value = HttpUtil.httpPostFileData(url ,xml);
        }else{
            Random random = new Random();
            StringBuilder str = new StringBuilder();
            for(int i=0 ;i<8 ;i++){
                str.append(random.nextInt(10));
            }
            String nonce = str.toString();
            String timestamp = String.valueOf(System.currentTimeMillis());
            String[] tmp = new String[]{token,timestamp,nonce};
            Arrays.sort(tmp);
            StringBuilder builder = new StringBuilder();
            for(String str2 : tmp){
                builder.append(str2);
            }
            //进行sha1加密
            String signature = SHA1.encode(builder.toString());
            url = url + "?timestamp=" + timestamp + "&nonce=" + nonce + "&signature=" + signature + "&echostr=" + token;
            value = HttpUtil.httpGet(url);
            if(value.equals(token)){
                value = "{\"status\": \"1\"}";
            }else{
                value = "{\"status\": \"0\"}";
            }
        }
        return value;
    }
}
