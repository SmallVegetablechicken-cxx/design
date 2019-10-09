package com.sise.design.general.util.content;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/30 12:32
 * @Descript: 登录状态回传
 * @Version: 1.0
 */

@Component
public class AjaxDataMsg {

    public final static int STATUS_LOGIN_SUCCESS =  1;
    public final static int STATUS_LOGIN_FAILURE = -1;
    public final static int STATUS_LOGIN_NULL =  -2;
    public final static int STATUS_LOGIN_LONGTIME = -3;
    public final static int STATUS_OTHER   =  0;
    public final static int STATUS_RE_SUCCESS =  11;
    public final static int STATUS_RE_FAILURE =  -11;
    public final static int STATUS_AJAX_FAILURE =  -31;
    public final static int STATUS_AJAX_SUCCESS =  31;
    public final static int STATUS_UPDATE_FAILURE =  -41;
    public final static int STATUS_UPDATE_SUCCESS =  41;
    public final static int STATUS_DEL_FAILURE =  -51;
    public final static int STATUS_DEL_SUCCESS =  51;
    public final static int STATUS_SUCCESS   =  99;
    public final static int STATUS_FAILURE   =  -99;


    private final static String MSG_LOGIN_SUCCESS = "登入成功";
    private final static String MSG_LOGIN_FAILURE = "登入失败，账户或者密码错误";
    private final static String MSG_FAILURE_LONGTIME = "登录已过期，请重新登录";
    private final static String MSG_OTHER   = "未知错误";
    private final static String MSG_RE_SUCCESS = "修改密码成功";
    private final static String MSG_RE_FAILURE = "修改失败，原密码错误";
    private final static String MSG_AJAX_SUCCESS = "提交成功";
    private final static String MSG_AJAX_FAILURE = "提交失败";
    private final static String MSG_UPDATE_SUCCESS = "修改信息成功";
    private final static String MSG_UPDATE_FAILURE = "修改信息失败";
    private final static String MSG_DEL_SUCCESS = "删除信息成功";
    private final static String MSG_DEL_FAILURE = "删除信息失败";
    private final static String MSG_NULL = "账号或者密码不能为空";
    private final static String MSG_SUCCESS = "成功";
    private final static String MSG_FAILURE = "出错";

    private static Map<Integer,String> msgMap = new LinkedHashMap<>();

    static {
        msgMap.put(STATUS_LOGIN_SUCCESS,MSG_LOGIN_SUCCESS);
        msgMap.put(STATUS_LOGIN_FAILURE,MSG_LOGIN_FAILURE);
        msgMap.put(STATUS_OTHER,MSG_OTHER);
        msgMap.put(STATUS_RE_SUCCESS,MSG_RE_SUCCESS);
        msgMap.put(STATUS_RE_FAILURE,MSG_RE_FAILURE);
        msgMap.put(STATUS_AJAX_FAILURE,MSG_AJAX_FAILURE);
        msgMap.put(STATUS_LOGIN_LONGTIME,MSG_FAILURE_LONGTIME);
        msgMap.put(STATUS_AJAX_SUCCESS,MSG_AJAX_SUCCESS);
        msgMap.put(STATUS_UPDATE_FAILURE,MSG_UPDATE_FAILURE);
        msgMap.put(STATUS_UPDATE_SUCCESS,MSG_UPDATE_SUCCESS);
        msgMap.put(STATUS_LOGIN_NULL,MSG_NULL);
        msgMap.put(STATUS_DEL_FAILURE,MSG_DEL_FAILURE);
        msgMap.put(STATUS_DEL_SUCCESS,MSG_DEL_SUCCESS);
        msgMap.put(STATUS_SUCCESS,MSG_SUCCESS);
        msgMap.put(STATUS_FAILURE,MSG_FAILURE);
    }

    public static String getMsg(int status){
        return msgMap.get(status);
    }
}
