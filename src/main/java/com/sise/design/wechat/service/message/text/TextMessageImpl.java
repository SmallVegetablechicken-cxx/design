package com.sise.design.wechat.service.message.text;

import com.sise.design.wechat.dao.WechatStrDAO;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import com.sise.design.wechat.service.message.Message;
import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/25 22:52
 * @Descript: TODO
 * @Version: 1.0
 */

@Service
public class TextMessageImpl extends Message {

    private String keyword;
    private String category;
    private String entity;

    private WechatStrDAO weChatStrDAO = new WechatStrDAO();

    public TextMessageImpl(Map<String,String> map){
        super(map);
        this.keyword =  map.get("Content");
        weChatStrDAO.insertStr( map.get("FromUserName"), this.keyword, WechatStr.MSG_ACTION_GET, WechatStr.MSG_TYPE_TEXT);
        this.category = this.keyword.substring(0,2);
        this.entity   = this.keyword.substring(2);
        this.classifyMessage();
        this.packMessage();
    }

    @Override
    public void classifyMessage() {

        switch (this.category){
            case "测试":
                this.content = "测试完成";
                this.messageMap.put("Content",content);
                this.messageType = MessageUtil.TEXT;
                break;

            case "功能":
                this.content = "测试完成2";
                this.messageMap.put("Content",content);
                this.messageType = MessageUtil.TEXT;
                break;

            default:
                this.messageType = MessageUtil.SUCCESS;
                break;
        }
    }

    public TextMessageImpl(){

    }

}
