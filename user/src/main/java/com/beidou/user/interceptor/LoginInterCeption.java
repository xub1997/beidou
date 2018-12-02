package com.beidou.user.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterCeption implements HandlerInterceptor {
    /*
    * 该方法将在请求处理之前进行调用
    * 可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，
    * 也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。
    * 该方法的返回值是布尔值Boolean类型的，
    * 当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会再执行；
    * 当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，
    * 如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //System.out.println("登录拦截器");
        return true;
    }

    /**
     * 该方法将在Controller执行之后，返回视图之前执行，modelAndView表示请求Controller处理之后返回的Model和View对象，所以可以在
     * 这个方法中修改modelAndView的属性，从而达到改变返回的模型和视图的效果。
     * 这个方法包括后面要说到的afterCompletion 方法都只能是在当前所属的Interceptor 的preHandle 方法的返回值为true 时才能被调用。
     * postHandle 方法，顾名思义就是在当前请求进行处理之后，也就是Controller 方法调用之后执行，
     * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    /*
    * 该方法也是需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行。
    * 顾名思义，该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的。
    * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }

}
