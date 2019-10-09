package com.sise.design.general.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author: Chen xuexin
 * @Time: 2019/8/2 13:15
 * @Descript: TODO
 * @Version: 1.0
 */

@ControllerAdvice
class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error/error";
    private static final String DEFAULT_ERROR_JSON = "error/jsonError";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e)  {

        e.printStackTrace();
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", response.getStatus());
        mav.addObject("url", request.getRequestURL());
        mav.addObject("message", e.getMessage());
        if (type(contentTypeHeader ,acceptHeader ,xRequestedWith)) {
            mav.addObject("time", System.currentTimeMillis());
            mav.addObject("tip", "请用浏览器访问查看具体错误");
            mav.setViewName(DEFAULT_ERROR_JSON);
        } else {
            mav.addObject("error", Arrays.toString(e.getStackTrace()));
            mav.setViewName(DEFAULT_ERROR_VIEW);
        }
        return mav;
    }

    private boolean type(String contentTypeHeader ,String acceptHeader ,String xRequestedWith){
        if( acceptHeader != null && !acceptHeader.contains("text/html") ){
            return true;
        }
        if( contentTypeHeader != null && !contentTypeHeader.contains("text/html") ){
            return true;
        }
        if ( "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return true;
        }
        return false;
    }
}
