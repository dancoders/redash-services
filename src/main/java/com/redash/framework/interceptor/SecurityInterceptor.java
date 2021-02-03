package com.redash.framework.interceptor;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private static final Log logger = LogFactory.get();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        // 请求地址
        String requestUrl = request.getRequestURI().toString();
        String userName = request.getRemoteUser();

//        String token = "Bearer zhoufeifan";
//
//        if (request.getHeader("Authorization").equals(token)) {
//            logger.info("request-Authorization：" + request.getHeader("Authorization"));
//        }

        // 请求IP
        logger.info("request请求的用户为：" + userName);
        logger.info("request请求的URL为：" + requestUrl);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle.........");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.........");
    }
}
