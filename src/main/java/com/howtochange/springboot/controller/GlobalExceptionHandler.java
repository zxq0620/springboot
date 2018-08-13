package com.howtochange.springboot.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {

    private String default_error_page = "error";


    @ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandler(Exception ex){
        ModelAndView map = new ModelAndView();
        map.addObject("msg",ex.getMessage());
        map.setViewName(default_error_page);
        return map;
    }
}
