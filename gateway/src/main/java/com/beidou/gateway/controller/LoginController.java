package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.common.util.vcode.Captcha;
import com.beidou.common.util.vcode.GifCaptcha;
import com.beidou.gateway.dao.UserMapper;
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
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private static final String CODE_KEY = "gifCode";
    private static final int width=150;
    private static final int height=40;
    private static final int length=4;

    @Autowired
    private UserMapper userMapper;

    @SysLogger("用户登录")
    @PostMapping("/login")
    public ResponseMsg login(@RequestParam("username")String username,@RequestParam("pwd")String pwd ,@RequestParam("code")String code,@RequestParam(value = "rememberMe",defaultValue = "false")boolean rememberMe){
        if (StringUtil.isEmpty(code)) {
            return ResponseMsg.Error("验证码不能为空！");
        }
        Session session = SecurityUtils.getSubject().getSession();
        String sessionCode = (String) session.getAttribute(CODE_KEY);
        if (!code.equalsIgnoreCase(sessionCode)) {
            return ResponseMsg.Error("验证码错误！");
        }
        if(!StringUtil.isEmpty(pwd)&&!StringUtil.isEmpty(username)){
            try{
                // 密码 BASE64加密(两次加密)
                pwd=StringUtil.encryptByBASE64(pwd.getBytes());
                pwd=StringUtil.encryptByBASE64(pwd.getBytes());
            }catch(Exception e){
                e.printStackTrace();
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, pwd, rememberMe);
            try {
                Subject subject = SecurityUtils.getSubject();
                if (subject != null)
                    subject.logout();
                SecurityUtils.getSubject().login(token);

                return ResponseMsg.Success("登录成功！",token);
            } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
                return ResponseMsg.Error(e.getMessage());
            } catch (AuthenticationException e) {
                return ResponseMsg.Error("登录失败！");
            }
        }else{
            return ResponseMsg.Error("请输入用户名跟密码");
        }

    }

    @SysLogger("获取验证码")
    @GetMapping(value = "gifCode")
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
            HttpSession session = request.getSession(true);
            captcha.out(response.getOutputStream());
            session.removeAttribute(CODE_KEY);
            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
            logger.info("生成验证码："+captcha.text().toLowerCase());
        } catch (Exception e) {
            logger.error("图形验证码生成失败", e);
        }
    }


}
