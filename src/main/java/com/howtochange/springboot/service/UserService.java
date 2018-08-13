package com.howtochange.springboot.service;

import com.howtochange.springboot.pojo.User;

public interface UserService {

    int add(User user);

    int delete(User user);

    int update(User user);

    int selectByPhone(String phone);

    User check(String phone,String password);
}
