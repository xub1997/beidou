package com.beidou.common.util;

import java.util.Set;

public class Judge<T> {
    public  boolean judge(Set<T> list, T object){
        for(T t:list){
            if(t.equals(object))return false;
        }
        return true;
    }
}
