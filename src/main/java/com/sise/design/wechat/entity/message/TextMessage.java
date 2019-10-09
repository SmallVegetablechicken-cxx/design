package com.sise.design.wechat.entity.message;

import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: :  Chen xuexin
 * @Time:      2019/7/15 23:17
 * @Descript:  TODO
 * @Version:   1.0
 */

@Component
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public TextMessage(Map map){
        super(map);
        MsgType      = MessageUtil.TEXT;
        this.Content = (String) map.get("Content");
    }

    public TextMessage(){

    }
}
