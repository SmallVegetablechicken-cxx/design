package com.sise.design.wechat.controller;

import com.sise.design.wechat.service.WeChatMessageServiceImpl;
import com.sise.design.wechat.util.MessageUtil;
import com.sise.design.wechat.util.WeChatCheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author:   Chen xuexin
 * @Time:     2019/7/15 0:08
 * @Descript: 微信接口控制器
 * @Version:  1.0
 */

@Async("ThreadPool")
@Controller
public class WechatController {

    private static Logger log = LoggerFactory.getLogger(WechatController.class);

    /**
     * @author:  Chen xuexin
     * @Time:    2019/7/15 0:17
     * @return 验证
     */
    @ResponseBody
    @RequestMapping(value = "/weixin",method= RequestMethod.GET)
    public CompletableFuture<String> login(HttpServletRequest request ){
        String signature = request.getParameter("signature") == null ? "" : request.getParameter("signature");
        String timestamp = request.getParameter("timestamp") == null ? "" : request.getParameter("timestamp");
        String nonce     = request.getParameter("nonce")     == null ? "" : request.getParameter("nonce");
        String echostr   = request.getParameter("echostr")   == null ? "" : request.getParameter("echostr");
        if(WeChatCheckUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("公众号接入成功");
            return CompletableFuture.completedFuture(echostr);
        }
        log.info("公众号接入失败");
        return CompletableFuture.completedFuture("111");
    }

    /**
     * @author : Chen xuexin
     * @Time:    2019/7/15 0:17
     * @return 内容
     */

    @ResponseBody
    @RequestMapping(value = "/weixin",method= RequestMethod.POST)
    public CompletableFuture<String> index(HttpServletRequest request)  {
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> xml = MessageUtil.parseXml(request);
            if(xml.size()==0){ return CompletableFuture.completedFuture(MessageUtil.SUCCESS); }
            log.info(xml.toString());
            WeChatMessageServiceImpl weChatMessageService = new WeChatMessageServiceImpl();
            String message = weChatMessageService.weixinMessageProcessService(xml);
            System.out.println(message);
            return CompletableFuture.completedFuture(message);
        } catch (UnsupportedEncodingException e) {
            System.out.println("-------------------------start print exception message--------------------------------");
            if(e.getMessage() == null){
                e.printStackTrace();
            }else{
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------end print exception message--------------------------------");
            return CompletableFuture.completedFuture(MessageUtil.SUCCESS);
        }
    }
}
