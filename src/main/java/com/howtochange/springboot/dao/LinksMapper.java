package com.howtochange.springboot.dao;

import com.howtochange.springboot.pojo.Links;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinksMapper extends BaseMapper<Links>{
    int insert(Links record);

    int insertSelective(Links record);

    List<Links> selectByKeyWord(@Param("key") String key);

    List<Links> selectByType(@Param("type") String type);

    @Override
    default int delete(Links links) {
        return 0;
    }

    @Override
    default int upate(Links links) {
        return 0;
    }

    @Override
    default Links selectByPk(int pk) {
        return null;
    }
}