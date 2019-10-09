package com.sise.design.general.entity;

/**
 * @author: Chen xuexin
 * @Time: 2019/10/4 15:26
 * @Descript: TODO
 * @Version: 1.0
 */

public class Parameter extends BaseEntity{

    private static final long SERIAL_VERSION_UID = 4414210753514765L;

    private String parameterType;
    private String parameterName;
    private String parameterValue;
    private String updateTime;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", parameterType:'" + parameterType + '\'' +
                ", parameterName:'" + parameterName + '\'' +
                ", parameterValue:'" + parameterValue + '\'' +
                '}';
    }

    public Parameter() {
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}