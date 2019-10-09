package com.sise.design.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sise.design.admin.service.StaffService;
import com.sise.design.general.dao.ParameterDAO;
import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Parameter;
import com.sise.design.general.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/19 16:59
 * @Descript: TODO
 * @Version: 1.0
 */

@RequestMapping( value = "/admin/admin")
@Controller("Admin_AdminController")
public class AdminController extends AdminBaseController {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    StaffService staffService;
    @Autowired
    ParameterDAO parameterDAO;

    @RequestMapping( value = "/info")
    public String staffInfo(Model model , HttpServletRequest request ){
        int id = (int) request.getSession().getAttribute("d_admin_id");
        Staff staff = staffDAO.selectById( id );
        model.addAttribute("staff", staff);
        return "admin/admin/info";
    }

    @ResponseBody
    @RequestMapping( value = "/updateInfo")
    public AjaxData updateUserInfo( HttpServletRequest request ){
        int id   = Integer.parseInt(request.getParameter("id"));
        return staffService.staffDataUpdate(id ,"update" , request);
    }

    @RequestMapping( value = "/parameter")
    public String parameter(){
        return "admin/admin/parameter";
    }

    @ResponseBody
    @RequestMapping( value = "/parameterData")
    public AjaxData coachData( HttpServletRequest request ){
        QueryWrapper<Parameter> wrapper=new QueryWrapper<>();
        String parameterName = request.getParameter("parameterName");
        if(parameterName !=null ){
            wrapper.like("parameter_name",parameterName);
        }
        Page<Parameter> page = this.getPages(request);
        List<Parameter> list= parameterDAO.selectParameterList(page,wrapper);
        ajaxData.setData(list);
        return ajaxData;
    }

}
