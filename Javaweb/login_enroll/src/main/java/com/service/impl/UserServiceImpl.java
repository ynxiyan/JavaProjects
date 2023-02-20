package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.User;
import com.service.UserService;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 11:20
 * @注释:实现UserService
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public boolean enroll(User user) {
        //如果返回大于0的值则添加用户成功
        return userDao.insertUser(user) > 0;
    }
}
