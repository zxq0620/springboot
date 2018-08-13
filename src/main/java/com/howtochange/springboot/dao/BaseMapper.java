package com.howtochange.springboot.dao;

public interface BaseMapper<T> {

    int insert(T t);

    int delete(T t);

    int upate(T t);

    T selectByPk(int pk);

}
