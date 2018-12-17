package com.beidou.gateway.config;


import com.beidou.gateway.entity.Role;
import com.beidou.gateway.entity.Rule;
import com.beidou.gateway.entity.User;

import com.beidou.gateway.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class MyShiroRealm extends AuthorizingRealm {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);


    @Autowired
    private LoginService loginService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份(登录认证)
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        /*try{
            // 密码 BASE64解密
            password=StringUtil.decryptByBASE64(password);
        }catch(Exception e){
            e.printStackTrace();
        }*/
        // 从数据库获取对应用户名密码的用户
        /*User user = loginService.login(username);

        // 用户为禁用状态
        if (user.getStatus()==0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        if(!user.getPwd().equals(password)){
            throw new IncorrectCredentialsException("密码错误！");
        }*/
        if(username==null){
            throw new UnknownAccountException("用户名错误！");
        }
        logger.info("---------------- Shiro 凭证认证成功 ----------------------");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                password,//密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("---------------- 用户名： ---------------------"+principal);
        if (principal instanceof String) {
            String username = (String) principal;
            User user = loginService.login(username);

            // 获取用户角色集
            List<Role> roleList = user.getRoles();
            Set<String> roleSet = roleList.stream().map(Role::getRolename).collect(Collectors.toSet());
            authorizationInfo.setRoles(roleSet);
            // 获取用户权限集
            List<Rule> permissionList=new ArrayList<>();
            for(Role role:roleList){
                for(Rule rule:role.getPermissions()){
                    permissionList.add(rule);
                    System.out.println(rule.toString());
                }
            }
            Set<String> permissionSet = permissionList.stream().map(Rule::getPermissions).collect(Collectors.toSet());
            System.out.println(permissionSet.toString());
            authorizationInfo.setStringPermissions(permissionSet);

        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }


    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
