package com.sise.design.wechat.service.message.event;

import com.sise.design.wechat.dao.WechatStrDAO;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import com.sise.design.wechat.service.message.Message;
import com.sise.design.wechat.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/25 22:52
 * @Descript: TODO
 * @Version: 1.0
 */


public class EventMessageImpl extends Message {

    private String event;

    @Autowired
    private WechatStrDAO dao;

    public EventMessageImpl(Map<String,String> map){
        super(map);
        this.event = map.get("Event");
        dao.insertStr(map.get("FromUserName"), this.event, WechatStr.MSG_ACTION_GET, WechatStr.MSG_TYPE_EVENT);
        this.classifyMessage();
        this.packMessage();
    }

    @Override
    public void classifyMessage() {

        switch (this.event){
            case MessageUtil.EVENT_SUBSCRIBE:
                content = "欢迎关注";
                messageMap.put("Content",content);
                messageType = MessageUtil.TEXT;
                break;

            case MessageUtil.EVENT_UNSUBSCRIBE:
                content = "欢迎再来";
                messageMap.put("Content",content);
                messageType = MessageUtil.TEXT;
                break;

            default:
                content = "其他功能暂未开发";
                messageMap.put("Content",content);
                messageType = MessageUtil.TEXT;
                break;
        }
    }

    public EventMessageImpl(){

    }

}
