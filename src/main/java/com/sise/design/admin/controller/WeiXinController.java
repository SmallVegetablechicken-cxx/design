package com.sise.design.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.admin.service.WeiXinService;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.wechat.dao.WechatStrDAO;
import com.sise.design.wechat.entity.mybatis.WechatStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/31 10:34
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping( value = "/admin/weixin")
@Controller("Admin_WeiXinController")
public class WeiXinController extends AdminBaseController {

    @Autowired
    WechatStrDAO weChatStrDAO;
    @Autowired
    AjaxData ajaxData;

    @RequestMapping( value = "/menu")
    public String userInfo(){
        return "admin/weixin/menu";
    }

    @RequestMapping( value = "/str")
    public String str(){
        return "admin/weixin/str";
    }

    @ResponseBody
    @RequestMapping( value = "/strValues" )
    public String strValues(HttpServletRequest request ){
        Page<WechatStr> pages = this.getPages(request);
        // 查询条件
        QueryWrapper<WechatStr> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("msg_time");
        int count = weChatStrDAO.getStrNum(null);
        List<WechatStr> list = weChatStrDAO.getStrList(pages ,wrapper);
        ajaxData.setCount(count);
        ajaxData.setData(list);
        return ajaxData.toString();
    }

    @RequestMapping( value = "/test")
    public String test(){
        return "admin/weixin/test";
    }

    @ResponseBody
    @RequestMapping( value = "/testValue")
    public String testValue(HttpServletRequest request){
        String url   = request.getParameter("mpurl");
        String token = request.getParameter("mptoken");
        String xml   = request.getParameter("mpxml");
        if("".equals(url)){
            return "请输入正确的地址";
        }
        String value = WeiXinService.testServer(url ,token ,xml);
        return value;
    }
}