package com.sise.design.wechat.entity.message;

import org.springframework.stereotype.Component;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 23:08
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
public class Image {

    private String MediaId;//素材id

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public Image(String mediaId) {
        MediaId = mediaId;
    }

    public Image() {

    }
}
