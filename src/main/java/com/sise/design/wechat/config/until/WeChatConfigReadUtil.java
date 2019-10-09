package com.sise.design.wechat.config.until;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author :   Chen xuexin
 * @Time:      2019/7/16 23:12
 * @Class:     WeixinConfig
 * @Descript:  TODO
 * @Version:   1.5
 */

@Component
@ConfigurationProperties(prefix="weixin")
public class WeChatConfigReadUtil {

    private static String appId;
    private static String appSecret;
    private static String token;

    public static String getToken() {
        return token;
    }

    @Value("${weixin.token}")
    public void setToken(String token) {
        WeChatConfigReadUtil.token = token;
    }

    public static String getAppId() {
        return appId;
    }

    @Value("${weixin.AppID}")
    public void setAppId(String appId) {
        WeChatConfigReadUtil.appId = appId;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    @Value("${weixin.AppSecret}")
    public void setAppSecret(String appSecret) {
        WeChatConfigReadUtil.appSecret = appSecret;
    }
}
