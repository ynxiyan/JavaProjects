package com.spring_ioc.factory;

import com.spring_ioc.dao.UserDao;
import com.spring_ioc.dao.impl.UserDaoImpl;

/**
 * @Author: XIYAN
 * @Date: 2023/3/10 15:24
 * @注释:
 */
public class UserDaoFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
