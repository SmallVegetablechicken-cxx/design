package com.sise.design.wechat.entity.message;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author:     Chen xuexin
 * @Time:      2019/7/15 23:14
 * @Descript:  TODO
 * @Version:   1.0
 */

@Component
public abstract class BaseMessage {

    // 收：开发者微信号  回：用户
    private String ToUserName;
    // 收：用户  回：开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/location/link）
    protected String MsgType;

    public BaseMessage(Map map){
        this.FromUserName = (String) map.get("ToUserName");
        this.ToUserName   = (String) map.get("FromUserName");
        this.CreateTime   = System.currentTimeMillis()/1000;
//        this.MsgType      = (String) map.get("MsgType");
    }

    public BaseMessage(){

    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

}
