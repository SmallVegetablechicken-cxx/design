package com.sise.design.general;

import com.alibaba.fastjson.JSON;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.util.content.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@RestController
public class test {

    @Autowired
    private UserDAO dao;

    @RequestMapping("/test")
    @ResponseBody
    public void a(HttpServletRequest request)  {
        Map map = request.getParameterMap();
        Collection collection=map.values();
        for (Object o : collection) {
            System.out.println(o);
        }
        System.out.println(JSON.toJSONString(request.getParameterMap()));
    }
}
