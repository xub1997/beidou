package com.beidou.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(RequestFilter.class) ;
    /**
     * 请求路由之前被拦截 实现 pre 拦截器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        String url=request.getRequestURI();
        logger.info("url ={}",url) ;
        /*if(url.equals("/api/v1/user/v2/api-docs")){
            return null;
        }
        if (token==null||"".equals(token.trim())){



            try {
                //登录路径
                if(!url.equals("/user/test1")){
                    logger.warn("need token");
                    //过滤请求(返回信息)
                    currentContext.setSendZuulResponse(false);
                    currentContext.setResponseStatusCode(401);
                    currentContext.setResponseBody("{\"msg\":\"need token!\"}");
                    currentContext.getResponse().sendRedirect("http://172.31.60.72:7000/user/test1");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null ;
        }
        logger.info("token ={}",token) ;*/

        return null;
    }
}
