package com.howtochange.springboot.controller;


import com.howtochange.springboot.pojo.User;
import com.howtochange.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @PostMapping("check")
    public String check(String phone , String password,
                        HttpServletRequest request, HttpServletResponse response,
                        ModelMap map){
        User user = (User) userService.loadUserByUsername(phone);
        if (user!=null&&user.getPassword().equals(password)){
            request.getSession().setAttribute(user.getPhone(),user);
            response.addCookie(new Cookie("sid",user.getPhone()));
            return "redirect:/";
        }else {
            map.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("forgot")
    public String forgot(){
        return "forgot";
    }
}
