package com.sise.design.general.model;

/**
 * @author: Chen xuexin
 * @Time: 2019/8/2 13:57
 * @Descript: TODO
 * @Version: 1.0
 */

public class ErrorMsg {
    private int status;
    private String url;
    private String message;
    private Long time = System.currentTimeMillis();
    private String tip = "请用浏览器访问查看具体错误";

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMsg(int status, StringBuffer url, String message) {
        this.status = status;
        this.url = url.toString();
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\"status\":" + status +
                "\n, \"url\":\"" + url + '\"' +
                "\n, \"message\":\"" + message + '\"' +
                "\n, \"time\":" + time +
                "\n, \"tip\":\"" + tip + '\"' +
                "\n}";
    }
}
