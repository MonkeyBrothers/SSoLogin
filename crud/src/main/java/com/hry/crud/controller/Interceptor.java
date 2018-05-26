package com.hry.crud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 单点登录拦截器
 */
public class Interceptor implements HandlerInterceptor {
    @Value("${SSO_HOST_URL}")
    private String SSO_HOST_URL;
    @Value("${CRUD_HOST_URL}")
    private String CRUD_HOST_URL;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 判断是否有全局会话
        HttpSession session = httpServletRequest.getSession();
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        // 判断得到的session是否为空并且是否为真
        if (isLogin != null && isLogin) {
            return true;
        }
        // 判断地址中是否存在token参数
        String token = httpServletRequest.getParameter("token");



        // 没有全局会话，重定向到统一认证中心，检查是否之前登陆过
        httpServletResponse.sendRedirect(SSO_HOST_URL + "/checkLogin?redirectUrl=" + CRUD_HOST_URL);
        return false;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
