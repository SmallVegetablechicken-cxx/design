package com.sise.design.wechat.entity.message;

import com.sise.design.wechat.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/22 23:08
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
public class ImageMessage extends BaseMessage {

    private Image Image;//Image节点

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public ImageMessage(Map map) {
        super(map);
        MsgType =         MessageUtil.IMAGE;
        Image   = (Image) map.get("Image");
    }

    public ImageMessage() {

    }
}
