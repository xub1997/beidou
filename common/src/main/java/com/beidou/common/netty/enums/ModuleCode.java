package com.beidou.common.netty.enums;

/**
 * 模块枚举
 */
public enum ModuleCode {
    SENDPOSITION(1);//上传位置模块

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ModuleCode(int code) {
        this.code = code;
    }

    public static ModuleCode getByCode(int code){
        for(ModuleCode temp:ModuleCode.values()){
            if(temp.getCode()==code){
                return temp;
            }
        }
        return null;
    }
}
