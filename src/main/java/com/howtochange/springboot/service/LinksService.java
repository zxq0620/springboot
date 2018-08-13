package com.howtochange.springboot.service;

import com.github.pagehelper.PageInfo;
import com.howtochange.springboot.pojo.Links;

import java.util.List;

public interface LinksService {

    int add(Links links);

    int delete(Integer pk);

    Links selectByPk(Integer pk);

    PageInfo<Links> select(String key, int pagenum);

    PageInfo<Links> selectByType(String type);
}
