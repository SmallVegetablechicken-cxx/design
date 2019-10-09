package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/2 13:20
 * @Descript: TODO
 * @Version: 1.0
 */

public class UserMoney extends BaseEntity{

    private static final long SERIAL_VERSION_UID = 4414210753514763L;

    private int uid;
    private double money;
    private int type;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", uid:" + uid +
                ", money:" + money +
                ", type:" + type +
                ", insertTime:'" + insertTime + '\'' +
                '}';
    }

    public UserMoney() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
