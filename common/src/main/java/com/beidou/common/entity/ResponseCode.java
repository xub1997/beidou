package com.beidou.common.entity;

public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(100,"ERROR");
    private final int code;
    private final String description;


    ResponseCode(int code,String description){
        this.code = code;
        this.description = description;
    }

    public int getCode(){
        return code;
    }
    public String getDescrition(){
        return description;
    }
}
