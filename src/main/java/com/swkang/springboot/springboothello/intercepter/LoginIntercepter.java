package com.swkang.springboot.springboothello.intercepter;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginIntercepter implements HandlerInterceptor {

    /**
     * 进入controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========LoginIntercepter=======preHandle========");
//        String access_token = request.getParameter("access_token");
//        System.out.println("access_token: "+access_token);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 调用方法之后，试图渲染之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========LoginIntercepter=======postHandle========");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 整个完成之后，通常用于资源清理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========LoginIntercepter=======afterCompletion========");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
