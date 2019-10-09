package com.sise.design.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.sise.design.general.util.service.RedisPoolUtil;
//import com.sise.design.general.util.service.RedisUtil;
import com.sise.design.general.util.content.DateTime;
import com.sise.design.general.util.web.HttpUtil;
import com.sise.design.wechat.entity.util.AccessToken;
import com.sise.design.wechat.config.until.WeChatConfigReadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author :  Chen xuexin
 * @Time:      2019/7/17 20:38
 * @Class:     AccessTokenUtil
 * @Descript:  TODO
 * @Version:   2.0
 */

@Component
public class AccessTokenUtil {

    private static final String APPID             = WeChatConfigReadUtil.getAppId();
    private static final String APPSECRET         = WeChatConfigReadUtil.getAppSecret();
    private static final String ACCESS_TOKEN_URL  = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static       String access_token;
    private static final Logger log               = LoggerFactory.getLogger(AccessTokenUtil.class);
    private static RedisPoolUtil redis = new RedisPoolUtil();

    public static String getAccessToken(){
        log.info(DateTime.getDateTime()+"：程序正在获取access_token");
        long time = AccessToken.getTimes();
        long now  = System.currentTimeMillis()/1000;
        if(now-time<7180){
            return AccessToken.getAccesstoken();
        }
        access_token = redis.get("access_token");
        if("".equals(access_token)){
            access_token = getAccessTokenByHttp();
        }
        return access_token;
    }

    private static String getAccessTokenByHttp() {

        String url            = ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET", APPSECRET);
        String content        = HttpUtil.httpGet(url);
        JSONObject jsonObject = JSONObject.parseObject(content);
        access_token          = jsonObject.getString("access_token");
        if("".equals(access_token)){
            log.error(DateTime.getDateTime()+"：网络申请access_token失败！！！");
        }
        AccessToken.setAccessToken(access_token);
        AccessToken.setTimes(System.currentTimeMillis()/1000);
        redis.set("access_token", access_token, 7180);

        return access_token;
    }
}