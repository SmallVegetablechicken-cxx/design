package com.sise.design.wechat.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author :   Chen xuexin
 * Time :      2019/7/15 22:20
 * interface : WeixinMessageService
 * Descript :  TODO
 * Version :   1.0
 */

@Repository
public interface WeChatMessageService {
    public String weixinMessageProcessService(Map<String,String> map) ;
}
