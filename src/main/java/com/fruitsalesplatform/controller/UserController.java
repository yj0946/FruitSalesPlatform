package com.fruitsalesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user/toLogin.action")
    public String toLogin() {
        return "/login.jsp";     //转向登录页面
    }
}
