package com.dao.impl;

import com.dao.UserDao;
import com.model.User;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 11:03
 * @注释:实现UserDao
 */
public class UserDaoImpl extends BasicDao implements UserDao {
    @Override
    public User selectUser(User user) {
        String sql = "select username,password from user where username=? and password=?";
        return selectOne(User.class, sql, user.getUsername(), user.getPassword());
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user(username,password) values(?,?)";
        return update(sql, user.getUsername(), user.getPassword());
    }
}
