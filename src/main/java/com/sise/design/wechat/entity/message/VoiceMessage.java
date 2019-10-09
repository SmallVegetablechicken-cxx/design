package com.sise.design.wechat.entity.message;

import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author:    Chen xuexin
 * @Time:      2019/7/15 23:17
 * @Descript:  音频消息
 * @Version:   1.0
 */

@Component
public class VoiceMessage extends BaseMessage {
    // 媒体ID
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public VoiceMessage(Map<String,String> map){
        super(map);
        MsgType = MessageUtil.VOICE;
        MediaId = map.get("MediaId");
    }

    public VoiceMessage(){

    }
}
