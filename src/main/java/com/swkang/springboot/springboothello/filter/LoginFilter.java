package com.swkang.springboot.springboothello.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载的时候调用
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    /**
     * 请求被拦截的时候调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginFilter");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse reqp = (HttpServletResponse)servletResponse;
        String userName = req.getParameter("userName");
        System.out.println("userName: " + userName);
        if("swkang".equals(userName)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            return;
        }
    }

    /**
     * 容器销毁的时候调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }

}
