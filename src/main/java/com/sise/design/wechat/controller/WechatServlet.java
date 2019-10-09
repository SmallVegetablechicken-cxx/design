package com.sise.design.wechat.controller;

import com.sise.design.wechat.service.WeChatMessageServiceImpl;
import com.sise.design.wechat.util.MessageUtil;
import com.sise.design.wechat.util.WeChatCheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/27 18:11
 * @Descript: TODO
 * @Version: 1.0
 */

@WebServlet
public class WechatServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(WechatServlet.class);

    @Override
    @RequestMapping(method= RequestMethod.GET)
    protected void doGet(HttpServletRequest request,HttpServletResponse response) {
        String signature = request.getParameter("signature") == null ? "" : request.getParameter("signature");
        String timestamp = request.getParameter("timestamp") == null ? "" : request.getParameter("timestamp");
        String nonce     = request.getParameter("nonce")     == null ? "" : request.getParameter("nonce");
        String echostr   = request.getParameter("echostr")   == null ? "" : request.getParameter("echostr");
        try {
            if(WeChatCheckUtil.checkSignature(signature, timestamp, nonce)) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(echostr);
                log.info("公众号接入成功");
            }else{
                response.getWriter().write("111");
                log.info("公众号接入失败");
            }
        } catch (IOException e) {
            log.info("公众号接入程序出错");
            System.out.println("-------------------------start print exception message--------------------------------");
            if(e.getMessage() == null){
                e.printStackTrace();
            }else{
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------end print exception message--------------------------------");
        }
    }

    @Override
    @RequestMapping(method= RequestMethod.POST)
    @Async("ThreadPool")
    protected void doPost(HttpServletRequest request,HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> xml = MessageUtil.parseXml(request);
            if(xml.size()==0){
                response.getWriter().write(MessageUtil.SUCCESS);
            }else{
                log.info(xml.toString());
                WeChatMessageServiceImpl weixinMessageService = new WeChatMessageServiceImpl();
                String message = weixinMessageService.weixinMessageProcessService(xml);
                System.out.println(message);
                response.getWriter().write(message);
            }
        } catch (IOException e) {
            System.out.println("-------------------------start print exception message--------------------------------");
            if(e.getMessage() == null){
                e.printStackTrace();
            }else{
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------end print exception message--------------------------------");
        }
    }
}
