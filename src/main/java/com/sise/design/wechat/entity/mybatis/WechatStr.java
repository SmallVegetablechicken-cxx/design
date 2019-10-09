package com.sise.design.wechat.entity.mybatis;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/26 13:04
 * @Descript: TODO
 * @Version: 1.0
 */

public class WechatStr {

    public static final int MSG_ACTION_GET    = 1;
    public static final int MSG_ACTION_REPLAY = 2;
    private static final String MSG_ACTION_GET_CONTENT    = "收到";
    private static final String MSG_ACTION_REPLAY_CONTENT = "回复";

    public static final int MSG_TYPE_TEXT  = 1;
    public static final int MSG_TYPE_EVENT = 2;
    public static final int MSG_TYPE_IMAGE = 3;
    public static final int MSG_TYPE_NEWS  = 4;
    private static final String MSG_TYPE_TEXT_CONTENT  = "文字";
    private static final String MSG_TYPE_EVENT_CONTENT = "事件";
    private static final String MSG_TYPE_IMAGE_CONTENT = "图片";
    private static final String MSG_TYPE_NEWS_CONTENT  = "图文";

    public static Map<Integer,String> MsgAction = new HashMap<>() ;
    public static Map<Integer,String> MsgType   = new HashMap<>() ;

    static {
        MsgAction.put(MSG_ACTION_GET,MSG_ACTION_GET_CONTENT);
        MsgAction.put(MSG_ACTION_REPLAY,MSG_ACTION_REPLAY_CONTENT);
        MsgType.put(MSG_TYPE_TEXT,MSG_TYPE_TEXT_CONTENT);
        MsgType.put(MSG_TYPE_EVENT,MSG_TYPE_EVENT_CONTENT);
        MsgType.put(MSG_TYPE_IMAGE,MSG_TYPE_IMAGE_CONTENT);
        MsgType.put(MSG_TYPE_NEWS,MSG_TYPE_NEWS_CONTENT);
    }

    private int id;
    private String user;
    private String msg;
    private String msgTime;
    private int msgAction;
    private int msgType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public int getMsgAction() {
        return msgAction;
    }

    public void setMsgAction(int msgAction) {
        this.msgAction = msgAction;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public WechatStr(String user, String msg, int msgAction, int msgType) {
        this.user = user;
        this.msg = msg;
        this.msgAction = msgAction;
        this.msgType = msgType;
    }



    public WechatStr() {
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", msg='" + msg + '\'' +
                ", msgTime=" + msgTime +
                ", msgAction=" + msgAction +
                ", msgType=" + msgType +
                '}';
    }


}
