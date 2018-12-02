package web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String path = request.getServletPath();
        if (path.startsWith("/images/") || path.startsWith("/css/") || path.startsWith("/js/")){//放行静态资源的请求
            return true;
        }
        if(path.startsWith("/login")){
            return true;
        }
        if(null != request.getSession().getAttribute("user")){
            return true;
        }
        response.sendRedirect("/login");
        return false;
        */
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
