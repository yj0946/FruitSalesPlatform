package com.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String strUri = httpServletRequest.getRequestURI();
//        if (strUri.contains("swagger") || strUri.contains("webjars") || strUri.contains("v2")) {
//            return true;
//        }
//
//        if (strUri.contains("insertPost")) {
//            return true;
//        }
//
//        if (!(strUri.contains("Login") || strUri.contains("login") || strUri.contains("register"))) {
//            //非登录请求
//            if (httpServletRequest.getSession().getAttribute("user") != null) {
//                return true;       //说明已经登录过,放行
//            } else {
//                if (strUri.contains("css") || strUri.contains("js") || strUri.contains("image")) {
//                    return true;       //如果是静态资源请求,放行
//                } else {
//                    //没有登录,跳转到登录界面
//                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toLogin.action");
//                }
//            }
//        } else {
//            //登录请求,直接放行
//            return true;
//        }
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
