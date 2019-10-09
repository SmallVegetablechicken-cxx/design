package com.sise.design.general.entity;

import com.alibaba.fastjson.JSON;
import com.sise.design.general.util.content.AjaxDataMsg;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/30 12:32
 * @Descript: 登录状态回传
 * @Version: 1.0
 */

@Component
public class AjaxData {

    private int code = 0;
    private int status = 99;
    private String msg = "获取数据";
    private int count;
    private Object data;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
        this.msg = AjaxDataMsg.getMsg(status);
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AjaxData(int status, Object data) {
        this.status = status;
        this.data = data;
        msg = AjaxDataMsg.getMsg(status);
    }

    public AjaxData() {
    }

    @Override
    public String toString() {
        return "{" +
                "\n\"code\" : " + code +
                "\n, \"status\" : " + status +
                "\n, \"msg\" : \"" + msg + '\"' +
                "\n, \"data\" : " + JSON.toJSONString(data) +
                "\n}";
    }
}
