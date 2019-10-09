package com.sise.design.wechat.service.message;

/**
 * @author:   Chen xuexin
 * @Time:     2019/7/25 21:45
 * @Descript: TODO
 * @Version:  1.0
 */

interface MessageInterface {

    /**
     * 区分消息方向
     */
    public void classifyMessage();

    /**
     * 返回包装完的消息
     * @return String
     */
    public String returnMessage();

    /**
     * 包装消息内容
     */
    public void packMessage();

}
