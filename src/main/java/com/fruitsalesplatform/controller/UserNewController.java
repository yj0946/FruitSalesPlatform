package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserNewController extends BaseController {
    public static final String STRING_EMPTY = "";
    @Resource
    UserService userService;
    @RequestMapping(value = {"/user/toLogin.action"}, method = {RequestMethod.GET})
    private String toLogin() {
        return "/login.jsp";    //转向登录页面
    }

    //列表
    @RequestMapping(value = {"user/login.action"}, method = {RequestMethod.POST})
    private String login(User user, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUserName());
        map.put("password", user.getPassword());
        List<User> lstUser = userService.getMoreRecord(map);
        if (lstUser != null && lstUser.size() > 0) {
            request.getSession().setAttribute("user", lstUser.get(0));
            return "/home.jsp";
        }

        model.addAttribute("errorMsg", "登录失败!账号或密码错误!");     //错误消息
        return "/login.jsp";    //转向登录页面
    }

    //跳转至注册页面
    @RequestMapping(value = "/user/registerPage.action", method = {RequestMethod.GET})
    public String toRegister() {
        return "test/register.jsp";  //转向注册页面
    }

    //注册
    @RequestMapping(value = "/user/registerPage.action", method = {RequestMethod.POST})
    public String register(User user, Model model, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
            //查找账号是否被注册
        Map<String, String> map = new HashMap<>();
        map.put("username", user == null ? STRING_EMPTY : user.getUserName());
        List<User> lstUser = userService.getMoreRecord(map);
        if (lstUser != null && lstUser.size() > 0) {
            //如果查询到了,说明账户已经被注册了,提示用户,并转发会注册页面
            model.addAttribute("errorMsg", "注册失败, 用户名已被占用!");
            return "test/register.jsp";
        }
        userService.insertRecord(user);
        model.addAttribute("noticeMsg", "注册成功!请输入账号密码登录"); //错误信息
        return "/login.jsp";
    }

    @RequestMapping(value = "getCommonParam", method = {RequestMethod.GET})
    @ResponseBody
    public String getCommonParam(@RequestParam(value = "username", required = false)String strUserName,
                                 @RequestParam(value = "password", required = false)String strPassword) {
        System.out.println("username:" + strUserName + ",password:" + strPassword);
        return strUserName;
    }

    @RequestMapping(value = "getCommonByUser", method = {RequestMethod.GET})
    @ResponseBody
    public String getCommonByUser(User user)
    {
        System.out.println("username:" + user.getUserName() + ",password:" + user.getPassword());
        return user.getUserName();
    }

    @RequestMapping(value = "getCommonByUserPost", method = {RequestMethod.POST})
    @ResponseBody
    public String getCommonByUserPost(@RequestBody User user)
    {
        System.out.println("username:" + user.getUserName() + ",password:" + user.getPassword());
        return user.getUserName();
    }
}
