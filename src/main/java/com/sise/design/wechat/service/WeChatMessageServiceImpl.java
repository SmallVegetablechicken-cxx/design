package com.sise.design.wechat.service;

import com.sise.design.wechat.service.message.Message;
import com.sise.design.wechat.service.message.event.EventMessageImpl;
import com.sise.design.wechat.service.message.text.TextMessageImpl;
import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author :   Chen xuexin
 * @Time:      2019/7/15 22:48
 * @Descript:  TODO
 * @Version:   1.0
 */

@Service("WeixinMessageService")
public class WeChatMessageServiceImpl implements WeChatMessageService {

    @Override
    public String weixinMessageProcessService(Map<String,String> map) {

        String msgType = map.get("MsgType");
        String message = "";
        Message msg;

        switch (msgType){

            case MessageUtil.EVENT:
                msg = new EventMessageImpl(map);
                message = msg.returnMessage();
                break;

            case MessageUtil.TEXT:
                msg = new TextMessageImpl(map);
                message = msg.returnMessage();
                break;

            case MessageUtil.IMAGE:
                message="333";
                break;

            case MessageUtil.VOICE:
                message="444";
                break;

            case MessageUtil.VIDEO:
                message="555";
                break;

            case MessageUtil.SHORTVIDEO:
                message="666";
                break;

            case MessageUtil.LOCATION:
                message="777";
                break;

            case MessageUtil.LINK:
                message="888";
                break;

            default:
                break;
        }
        return message;
    }


}
