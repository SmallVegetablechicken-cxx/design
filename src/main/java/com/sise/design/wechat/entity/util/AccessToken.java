package com.sise.design.wechat.entity.util;

import org.springframework.stereotype.Component;

/**
 * user:      Chen xuexin
 * Time:      2019/7/17 19:38
 * Class:     AccessTokenUtil
 * Descript:  TODO
 * Version:   1.0
 */

@Component
public class AccessToken {

    private static String access_token;
    private static long   times = 0;

    public static String getAccesstoken() {
        return access_token;
    }

    public static void setAccessToken(String accesstoken) {
        AccessToken.access_token = accesstoken;
    }

    public static long getTimes() {
        return times;
    }

    public static void setTimes(long times) {
        AccessToken.times = times;
    }

    public AccessToken(String accesstoken, int times) {
        AccessToken.access_token = accesstoken;
        AccessToken.times       = times;
    }

    public AccessToken() {

    }
}
