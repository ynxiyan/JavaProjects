package com.dao.impl;

import com.dao.UsersDao;
import com.model.Users;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 17:21
 * @注释:实现用户接口
 */
public class UsersDaoImpl extends BasicDao implements UsersDao {
    @Override
    public Users selectUsers(Users users) {
        String sql = "select id,username,password from user where username=? and password=?";
        return selectOne(Users.class, sql, users.getUsername(), users.getPassword());
    }

    @Override
    public int insertUsers(Users users) {
        String sql = "insert into user(username,password) values(?,?)";
        return update(sql, users.getUsername(), users.getPassword());
    }
}
