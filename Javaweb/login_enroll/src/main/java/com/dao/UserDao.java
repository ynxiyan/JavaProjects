package com.dao;

import com.model.User;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 10:57
 * @注释:UserDao接口
 */
public interface UserDao {
    /**
     * 查询用户
     *
     * @param user 传入的用户名和密码
     * @return 返回查询到的用户
     */
    User selectUser(User user);

    /**
     * 添加用户
     *
     * @param user 传入用户名和密码
     * @return 返回受影响的行数
     */
    int insertUser(User user);

}
