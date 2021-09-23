package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.dao.impl.UserDaoImpl;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/user/insert.action", method = {RequestMethod.GET})
    private String insertUser(Model model){
        User user = new User();
        user.setUserName("jack");
        user.setPassword("1234");
        user.setName("张三");
        user.setTelephone("155585111554");
        int i = testService.insertUser(user);
        System.out.println("插入数据成功:" + user.getUserid());
        return "test/test.jsp";
    }
}
