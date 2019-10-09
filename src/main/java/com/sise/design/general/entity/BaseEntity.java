package com.sise.design.general.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/5 16:29
 * @Descript: TODO
 * @Version: 1.0
 */


public class BaseEntity {

    private static final long SERIAL_VERSION_UID = 4414210753514760L;

    protected int    id;
    protected String insertTime;
    @TableField("is_del")
    @TableLogic
    protected int isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
