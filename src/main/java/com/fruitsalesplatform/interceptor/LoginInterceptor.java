package com.fruitsalesplatform.interceptor;

import com.alibaba.fastjson.JSON;
import com.fruitsalesplatform.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

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

        showCookies(httpServletRequest, httpServletResponse);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    //读取cookie数组，之后迭代出各个cookie
    public void showCookies(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();//根据请求数据，找到cookie数组

        if (null==cookies) {//如果没有cookie数组
            System.out.println("没有cookie");
            addCookie(request, response);
        } else {
            boolean isExist = false;
            for(Cookie cookie : cookies){
                String strCookieName = cookie.getName();
                if (strCookieName.equals("userinfo")) {
                    isExist = true;
                    System.out.println("cookieName:"+cookie.getName()+",cookieValue:"+ cookie.getValue());
                    break;
                }
            }

            if (!isExist) {
                addCookie(request, response);
            }

        }
    }

    //创建cookie，并将新cookie添加到“响应对象”response中。
    public void addCookie(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String,String[]> pramMap = request.getParameterMap();
        User userSession = null;
        if (pramMap != null) {
            userSession = new User();
            if (pramMap.containsKey("UserName") && pramMap.containsKey("Password")) {
                userSession.setUserName(pramMap.get("UserName")[0]);
                userSession.setPassword(pramMap.get("Password")[0]);

                String strJson = JSON.toJSONString(userSession);
                Cookie cookie = new Cookie("userinfo", URLEncoder.encode(strJson, "utf-8"));//创建新cookie
                cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
                cookie.setPath("/");//设置作用域
                response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
            }
        }

    }

    //修改cookie，可以根据某个cookie的name修改它（不只是name要与被修改cookie一致，path、domain必须也要与被修改cookie一致）
    public void editCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookies");
        } else {
            for(Cookie cookie : cookies){
                //迭代时如果发现与指定cookieName相同的cookie，就修改相关数据
                if(cookie.getName().equals("name_test")){
                    cookie.setValue("new_value");//修改value
                    cookie.setPath("/");
                    cookie.setMaxAge(10 * 60);// 修改存活时间
                    response.addCookie(cookie);//将修改过的cookie存入response，替换掉旧的同名cookie
                    break;
                }
            }
        }
    }

    //删除cookie
    public void delCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie");
        } else {
            for(Cookie cookie : cookies){
                //如果找到同名cookie，就将value设置为null，将存活时间设置为0，再替换掉原cookie，这样就相当于删除了。
                if(cookie.getName().equals("name_test")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }


    /**
     * 获取IP地址的方法
     * @param request   传一个request对象下来
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
