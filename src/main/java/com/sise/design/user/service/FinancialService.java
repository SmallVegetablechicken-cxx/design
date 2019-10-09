package com.sise.design.user.service;

import com.sise.design.general.dao.UserDAO;
import com.sise.design.general.dao.UserMoneyDAO;
import com.sise.design.general.entity.AjaxData;
import com.sise.design.general.entity.User;
import com.sise.design.general.entity.UserMoney;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/2 19:36
 * @Descript: TODO
 * @Version: 1.0
 */

@Service("User_FinancialService")
public class FinancialService extends UserBaseService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserMoneyDAO userMoneyDAO;
    @Autowired
    AjaxData ajaxData;
    @Autowired
    FinancialService financialService;

    private int result;

    public AjaxData recharge(HttpServletRequest request , HttpSession session){
        int    id           = (int) session.getAttribute("d_user_id");
        String userPassword = request.getParameter("userPassword");
        double userMoney    = request.getParameter("userMoney") == null ?
                0:Double.parseDouble( request.getParameter("userMoney") );
        if(userMoney==0){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("金额为0");
            return  ajaxData;
        }
        User user = userDAO.selectById(id);
        if(user == null){
            ajaxData.setStatus(AjaxDataMsg.STATUS_FAILURE);
            return  ajaxData;
        }
        if(!user.getUserPassword().equals(userPassword)){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("验证密码失败");
            return  ajaxData;
        }
        user.setUserMoney(user.getUserMoney()+userMoney);
        UserMoney userMoneyData= new UserMoney();
        userMoneyData.setMoney(userMoney);
        userMoneyData.setType(2);
        userMoneyData.setUid(user.getId());
        userMoneyDAO.addUserMoney(userMoneyData);
        result = userDAO.updateUser(user);
        if(result >0 ){
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_SUCCESS);
            ajaxData.setMsg("充值成功");
        }else{
            ajaxData.setStatus(AjaxDataMsg.STATUS_AJAX_FAILURE);
            ajaxData.setMsg("充值失败");
        }
        return  ajaxData;
    }
}
