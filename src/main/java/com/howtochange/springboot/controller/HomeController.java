package com.howtochange.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//    配置默认首页
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/root/test")
    public String test(){
        return "home";
    }
}
