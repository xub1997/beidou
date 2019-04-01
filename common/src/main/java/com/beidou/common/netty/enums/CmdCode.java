package com.beidou.common.netty.enums;
/**
 * 命令枚举
 */
public enum CmdCode {
    LOGIN(1,"第一次连接"),//第一次连接
    SENDPOSITION(2,"发送位置"),//发送位置
    KEEPALIVE(3,"心跳包"),//保持心跳
    LOGOUT(4,"下线");//下线
    private int code;
    private String msg;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CmdCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CmdCode getByCode(int code){
        for(CmdCode temp:CmdCode.values()){
            if(temp.getCode()==code){
                return temp;
            }
        }
        return null;
    }

}
