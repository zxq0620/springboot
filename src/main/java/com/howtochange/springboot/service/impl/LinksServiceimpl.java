package com.howtochange.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.howtochange.springboot.dao.LinksMapper;
import com.howtochange.springboot.pojo.Links;
import com.howtochange.springboot.service.LinksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "links")
public class LinksServiceimpl implements LinksService {

    Logger logger = LoggerFactory.getLogger(LinksServiceimpl.class);

    @Autowired
    LinksMapper linksMapper;

    @Override
    public int add(Links links) {
        return 0;
    }

    @Override
    public int delete(Integer pk) {
        return 0;
    }

    @Override
    public Links selectByPk(Integer pk) {
        return null;
    }

    @Override
    @Cacheable(key = "#key+#pagenum")
    public PageInfo<Links> select(String key,int pagenum) {
        PageHelper.startPage(pagenum, 10);
        List<Links> links = linksMapper.selectByKeyWord(key);
        PageInfo<Links> pageInfo = new PageInfo<>(links);
        logger.info("添加缓存---------->"+key);
        return pageInfo;
    }

    @Override
    @Cacheable(key = "#type")
    public PageInfo<Links> selectByType(String type) {
        List<Links> links = linksMapper.selectByType(type);
        PageInfo<Links> pageInfo = new PageInfo<>(links);
        logger.info("添加缓存---------->"+type);
        return pageInfo;
    }

}
