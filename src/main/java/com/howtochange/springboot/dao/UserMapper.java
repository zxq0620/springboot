package com.howtochange.springboot.dao;

import com.howtochange.springboot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{
    int insert(User record);

    int insertSelective(User record);

    User selectByPhone(@Param("phone") String phone);
}