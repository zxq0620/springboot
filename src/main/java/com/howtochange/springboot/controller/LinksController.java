package com.howtochange.springboot.controller;


import com.github.pagehelper.PageInfo;
import com.howtochange.springboot.pojo.Links;
import com.howtochange.springboot.service.LinksService;
import com.howtochange.springboot.service.impl.LinksServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("links")
public class LinksController {

    @Autowired
    LinksService linksService;

    @RequestMapping("/search/bykeyword")
    public String searchLinks(String keyword,int pagenum, ModelMap map){
        PageInfo<Links> links = linksService.select("\'%"+keyword+"%\'",pagenum);
        map.addAttribute("links", links.getList());
        map.addAttribute("total",links.getTotal());
        map.addAttribute("nextpage",links.getNextPage());
        map.addAttribute("prepage",links.getPrePage());
        map.addAttribute("keyword",keyword);
        map.addAttribute("nowpage",pagenum);
        return "searchresault";
    }

    @RequestMapping("/search/bytype")
    public String searchByType(String type,ModelMap map){
        PageInfo<Links> links = linksService.selectByType(type);
        map.addAttribute("links",links);
        return "searchresault";
    }

}
