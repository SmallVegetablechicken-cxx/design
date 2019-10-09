package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/4 13:32
 * @Descript: TODO
 * @Version: 1.0
 */

public class UserWages extends BaseEntity{

    private static final long SERIAL_VERSION_UID = 4414210753514764L;

    private int uid;
    private int wages;
    private String wagesTime;
    private String updateTime;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", uid:" + uid +
                ", wages:" + wages +
                ", wagesTime:'" + wagesTime + '\'' +
                ", updateTime:'" + updateTime + '\'' +
                '}';
    }

    public UserWages() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    public String getWagesTime() {
        return wagesTime;
    }

    public void setWagesTime(String wagesTime) {
        this.wagesTime = wagesTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
