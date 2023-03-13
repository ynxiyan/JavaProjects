package com.spring_aop.dao;

/**
 * @Author: XIYAN
 * @Date: 2023/3/13 9:51
 * @注释:
 */
public interface BookDao {
    public void save();

    public void update();

    public String findName(int id);
}
