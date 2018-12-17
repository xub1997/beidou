package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.entity.Tree;
import com.beidou.common.util.StringUtil;
import com.beidou.common.util.TreeUtils;
import com.beidou.common.util.vcode.Captcha;
import com.beidou.common.util.vcode.GifCaptcha;
import com.beidou.gateway.entity.Role;
import com.beidou.gateway.entity.Rule;
import com.beidou.gateway.entity.User;
import com.beidou.gateway.service.LoginService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value = "LoginController|登录操作")
@RestController
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private static final String CODE_KEY = "gifCode";
    private static final int width=150;
    private static final int height=40;
    private static final int length=4;

    @Autowired
    private LoginService loginService;


    /*@GetMapping("/login")
    public String loginhtml(){
        return "login";
    }*/

    @SysLogger("用户登录")
    @GetMapping("/login")
    public ResponseMsg login(@RequestParam("username")String username,@RequestParam("pwd")String pwd ,
                             @RequestParam("code")String code,@RequestParam(value = "rememberMe",defaultValue = "false")boolean rememberMe){
        if (StringUtil.isEmpty(code)) {
            return ResponseMsg.Error("验证码不能为空！");
        }

        Session session = SecurityUtils.getSubject().getSession();
        String sessionCode = (String) session.getAttribute(CODE_KEY);
        System.out.println(session.getAttribute(CODE_KEY));
        /*if (!code.equalsIgnoreCase(sessionCode)) {//验证码检验
            return ResponseMsg.Error("验证码错误！");
        }*/
        if(!StringUtil.isEmpty(pwd)&&!StringUtil.isEmpty(username)){//用户名、密码判空

            try {
                // 从数据库获取对应用户名密码的用户
                User user = loginService.login(username);
                if(user==null){//用户不存在
                    return ResponseMsg.Error("用户名错误！");
                    /*throw new UnknownAccountException("用户名错误！");*/
                }
                else if (user.getStatus()==0) {// 用户为禁用状态
                    return ResponseMsg.Error("账号已被锁定,请联系管理员！");
                    /*throw new LockedAccountException("账号已被锁定,请联系管理员！");*/
                }
                else if(!user.getPwd().equals(StringUtil.encryptByMD5(pwd+user.getSalt()))){//密码不对应
                    return ResponseMsg.Error("密码错误！");
                    /*throw new IncorrectCredentialsException("密码错误！");*/
                }
                /*try{
                    // 密码 BASE64加密(三次加密)
                    pwd=StringUtil.encryptByBASE64(pwd);
                }catch(Exception e){
                    e.printStackTrace();
                }*/
                else{
                    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPwd(), rememberMe);
                    Subject subject = SecurityUtils.getSubject();
                    if (subject != null)subject.logout();//退出之前账号
                    subject.login(token);//登录
                    List<Tree<Rule>> trees = new ArrayList<>();
                    for(Role role:user.getRoles()){
                        for(Rule rule:role.getPermissions()){
                            Tree<Rule> tree = new Tree<>();
                            tree.setId(rule.getId().toString());
                            tree.setParentId(rule.getPid().toString());
                            tree.setText(rule.getRulename());
                            tree.setIcon("");
                            tree.setUrl(rule.getUrl());
                            trees.add(tree);
                        }
                    }
                    return ResponseMsg.Success("登录成功！",user,TreeUtils.build(trees));
                }

            } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
                return ResponseMsg.Error(e.getMessage());
            } catch (AuthenticationException e) {
                return ResponseMsg.Error("登录失败！");
            }
        }else{
            return ResponseMsg.Error("请输入用户名跟密码");
        }

    }


    @GetMapping(value = "/gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(
                   width ,//验证码宽度
                   height,//验证码高度
                   length);//验证码字符个数

            Session session = SecurityUtils.getSubject().getSession(true);
            captcha.out(response.getOutputStream());
            session.removeAttribute(CODE_KEY);
            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
            logger.info("生成验证码："+captcha.text().toLowerCase());
        } catch (Exception e) {
            logger.error("图形验证码生成失败", e);
        }
    }


}
