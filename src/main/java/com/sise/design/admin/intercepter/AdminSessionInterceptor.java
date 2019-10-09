package com.sise.design.admin.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 22:05
 * @Descript: TODO
 * @Version: 1.0
 */

@Component
public class AdminSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //System.out.println("出现拦截器扫描的链接："+request.getRequestURI());
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("d_admin_id") != null) {
            return true;
        } else {
            System.out.println("没有session，已拦截："+request.getRequestURI());
            try {
                response.sendRedirect("/admin/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        //System.out.println("返回视图或String之前的处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        //System.out.println("返回视图或String之后的处理");
    }
}

