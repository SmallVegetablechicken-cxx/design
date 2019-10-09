package com.sise.design.wechat.service.message;

import com.sise.design.wechat.dao.WechatStrDAO;
import com.sise.design.wechat.entity.message.ImageMessage;
import com.sise.design.wechat.entity.message.NewsMessage;
import com.sise.design.wechat.entity.message.TextMessage;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/25 21:57
 * @Descript: TODO
 * @Version: 1.0
 */

@Service
public abstract class Message implements MessageInterface {

    protected HashMap<String,Object> messageMap    = new HashMap<>();
    protected String                 messageString = "";

    protected String  messageType ;
    protected String  content ;

    private WechatStrDAO wechatStrDAO = new WechatStrDAO();

    protected Message(){ }

    protected Message(Map<String,String> map){
        messageMap.put("FromUserName", map.get("ToUserName"));
        messageMap.put("ToUserName",  map.get("FromUserName"));
    }

     @Override
     public void packMessage(){

         if(messageString.length()>0){ return; }

        switch (messageType){
            case MessageUtil.TEXT:
                TextMessage textMessage = new TextMessage(messageMap);
                messageString = MessageUtil.textMessageToXml(textMessage);
                wechatStrDAO.insertStr((String) messageMap.get("ToUserName"), (String) messageMap.get("Content"), WechatStr.MSG_ACTION_REPLAY, WechatStr.MSG_TYPE_TEXT);
                break;

            case MessageUtil.NEWS:
                NewsMessage newsMessage = new NewsMessage(messageMap);
                messageString = MessageUtil.newsMessageToXml(newsMessage);
                wechatStrDAO.insertStr((String) messageMap.get("ToUserName"), messageString, WechatStr.MSG_ACTION_REPLAY, WechatStr.MSG_TYPE_NEWS);
                break;

            case MessageUtil.IMAGE:
                ImageMessage imageMessage = new ImageMessage(messageMap);
                messageString = MessageUtil.imageMessageToXml(imageMessage);
                wechatStrDAO.insertStr((String) messageMap.get("ToUserName"), messageString, WechatStr.MSG_ACTION_REPLAY, WechatStr.MSG_TYPE_IMAGE);
                break;

            case MessageUtil.SUCCESS:
                messageString = MessageUtil.SUCCESS;
                break;

            default:
                messageMap.put("Content","暂不支持回复其他消息类型");
                TextMessage defaultMessage = new TextMessage(messageMap);
                messageString = MessageUtil.textMessageToXml(defaultMessage);
                wechatStrDAO.insertStr((String) messageMap.get("ToUserName"), (String)messageMap.get("Content"), WechatStr.MSG_ACTION_REPLAY, WechatStr.MSG_TYPE_TEXT);
        }
    }

    @Override
    public String returnMessage(){
        if("".equals(messageString)){
            this.packMessage();
        }
        return messageString;
    }

}
