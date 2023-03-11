package com.spring_disposition.factory;

import com.spring_disposition.dao.UserDao;
import com.spring_disposition.dao.impl.UserDaoImpl;

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
