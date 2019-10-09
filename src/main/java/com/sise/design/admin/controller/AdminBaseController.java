package com.sise.design.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.general.controller.GeneralBaseController;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.dao.UserWagesDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserWages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/30 20:15
 * @Descript: TODO
 * @Version: 1.0
 */

public class AdminBaseController extends GeneralBaseController {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserWagesDAO userWagesDAO;

    protected AjaxData getListStaffByWapper(HttpServletRequest request , QueryWrapper<Staff> wrapper){
        Page<Staff> pages = this.getPages(request);
        List<Staff> list = staffDAO.selectStaffList(pages,wrapper);
        int count = staffDAO.selectCount(wrapper);
        ajaxData.setData(list);
        ajaxData.setCount(count);
        return ajaxData;
    }

    protected AjaxData getListUserByWapper(HttpServletRequest request , QueryWrapper<User> wrapper){
        Page<User> pages = this.getPages(request);
        List<User> list = userDAO.selectUserList(pages,wrapper);
        for(int i=0;i<list.size();i++){
            User user = list.get(i);
            user.setUserWages(userWagesDAO.selectUserWagesByUid(user.getId()));
            list.set(i,user);
        }
        int count = userDAO.selectCount(wrapper);
        ajaxData.setData(list);
        ajaxData.setCount(count);
        return ajaxData;
    }

}
