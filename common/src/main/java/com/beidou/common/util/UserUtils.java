package com.beidou.common.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


import java.util.List;


public class UserUtils {

    /**
     * 获取当前登录用户的用户名
     * @return
     */
    public static String getUsername(){
        if(getSubject().getPrincipal()!=null){
            return getSubject().getPrincipal().toString();
        }
        return "登录";
    }


    /*
    * 获取shiro的当前Subject对象
    * */
    public static Subject getSubject() {
        Subject subject=SecurityUtils.getSubject();
        if(subject!=null){
            return subject;
        }
        return null;
    }


    /*
     * 获取shiro的当前session对象
     * */
    public static Session getRole(){
        return getSubject().getSession();
    }


}



