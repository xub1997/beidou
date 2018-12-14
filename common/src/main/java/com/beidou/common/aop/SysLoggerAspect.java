package com.beidou.common.aop;


import com.alibaba.fastjson.JSON;
import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.SysLog;
import com.beidou.common.service.LoggerService;
import com.beidou.common.util.HttpUtils;
import com.beidou.common.util.StringUtil;

import com.beidou.common.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Aspect
@Component
public class SysLoggerAspect {

    private final static Logger logger = LoggerFactory.getLogger(SysLoggerAspect.class);

    @Autowired
    private  SysLog sysLog;

    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间

    @Autowired
    private LoggerService loggerService;



    //@Pointcut("execution(* com.beidou..*.*(..)) && @annotation(com.beidou.logger.annotation.SysLogger)")
    @Pointcut("@annotation(com.beidou.common.annotation.SysLogger)")
    public void loggerPointCut() {

    }

    @Before("loggerPointCut()")
    public void saveSysLog(JoinPoint joinPoint) throws  Throwable{
        //设置IP地址
        sysLog.setIp(HttpUtils.getIpAddress());
        //请求方法
        sysLog.setRequestmethod(HttpUtils.getRequestMethod());
        //请求url
        sysLog.setUrl(HttpUtils.getRequestUrl());
        //获取注解的操作描述
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogger sysLogger = method.getAnnotation(SysLogger.class);
        if(sysLogger != null){
            //注解上的描述
            sysLog.setOperation(sysLogger.value());
        }
        //运行方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //请求的参数
        Object[]  args= joinPoint.getArgs();
        String params="";
        for(Object object:args){
            params+= JSON.toJSONString(object);
        }
        if(!StringUtils.isEmpty(params)) {
            sysLog.setParams(params);
        }
        //记录方法开始执行的时间
        startTimeMillis = System.currentTimeMillis();
        //创建时间
        sysLog.setCreatedate(StringUtil.dateToString(new Date()));
    }

    @AfterThrowing(pointcut = "loggerPointCut()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e){
        //异常
        if(e!=null){
            sysLog.setException(e.toString());
        }
        //操作人（用户名）
        String username="";
        sysLog.setUsername(username);
        if(UserUtils.getUsername()!=null&&!StringUtil.isEmpty(UserUtils.getUsername())){
            username = UserUtils.getUsername();
            sysLog.setUsername(username);
        }
        endTimeMillis = System.currentTimeMillis();
        sysLog.setTime(endTimeMillis-startTimeMillis);
        //保存系统日志
        loggerService.savelog(sysLog);
    }

    @AfterReturning(pointcut = "loggerPointCut()",returning = "object")
    public void doAfterReturing(Object object){
        //操作人（用户名）
        String username="";
        sysLog.setUsername(username);
        if(UserUtils.getUsername()!=null&&!StringUtil.isEmpty(UserUtils.getUsername())){
            username = UserUtils.getUsername();
            sysLog.setUsername(username);
        }
        endTimeMillis = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        Class userCla = (Class) object.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(object);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sysLog.setTime(endTimeMillis-startTimeMillis);
        //操作结果
        sysLog.setResult(map.toString());
        //异常
        sysLog.setException("无异常");
        logger.info("操作信息={}",sysLog.toString());
        //保存系统日志
        loggerService.savelog(sysLog);
    }


}

