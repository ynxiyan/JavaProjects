package com.service.impl;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.model.Users;
import com.service.UsersService;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 17:27
 * @注释:逻辑判断的用户接口
 */
public class UsersServiceImpl implements UsersService {
    private final UsersDao usersDao = new UsersDaoImpl();

    @Override
    public Users login(Users users) {
        return usersDao.selectUsers(users);
    }

    @Override
    public boolean register(Users users) {
        return usersDao.insertUsers(users) > 0;
    }
}
