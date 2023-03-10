package com.spring_ioc.service.impl;

import com.spring_ioc.dao.UserDao;
import com.spring_ioc.service.UserService;

/**
 * @Author: XIYAN
 * @Date: 2023/3/10 14:22
 * @注释:
 */
public class UserServiceImpl implements UserService {
    //删除业务层中使用new的方式创建的dao对象
    private UserDao userDao;

    //提供对应的set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void sout() {
        System.out.println("UserService");
        userDao.sout();
    }
}
