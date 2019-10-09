package com.sise.design.wechat.entity.message;

import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 22:41
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
public class MusicMessage extends BaseMessage {

    private Music Music;

    public MusicMessage(Map map) {
        super(map);
        MsgType =        MessageUtil.MUSIC;
        Music  = (Music) map.get("Music");
    }

    public MusicMessage() {

    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
