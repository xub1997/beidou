package com.beidou.common.entity;

import org.springframework.stereotype.Component;

@Component
public class SysLog {
    //操作日志id
    private int id;
    //用户名（操作人）
    private String username;
    //IP地址
    private String ip;
    //用户操作
    private String operation;
    //url
    private String url;
    //请求方法
    private  String requestmethod;
    //运行方法
    private String method;
    //请求参数
    private String params;
    //耗时
    private long  time;
    //异常
    private String exception;
    //结果
    private String result;
    //创建时间
    private String createdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRequestmethod() {
        return requestmethod;
    }

    public void setRequestmethod(String requestmethod) {
        this.requestmethod = requestmethod;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", operation='" + operation + '\'' +
                ", url='" + url + '\'' +
                ", requestmethod='" + requestmethod + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", time=" + time +
                ", exception='" + exception + '\'' +
                ", result='" + result + '\'' +
                ", createdate='" + createdate + '\'' +
                '}';
    }
}
