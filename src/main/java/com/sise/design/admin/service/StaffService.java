package com.sise.design.admin.service;

import com.sise.design.general.dao.StaffDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.Staff;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Chen xuexin
 * @Time: 2019/9/23 11:18
 * @Descript: TODO
 * @Version: 1.0
 */

@Service("Admin_StaffService")
public class StaffService extends AdminBaseService {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AjaxData ajaxData;


}
