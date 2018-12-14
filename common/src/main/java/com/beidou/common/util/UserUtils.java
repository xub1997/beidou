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
        return getSubject().getPrincipal().toString();
    }


    /*
    * 获取shiro的当前Subject对象
    * */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }


    /*
     * 获取shiro的当前session对象
     * */
    public static Session getRole(){
        return getSubject().getSession();
    }


}



