package com.dao;

import com.model.Users;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 17:18
 * @注释:用户接口
 */
public interface UsersDao {
    /**
     * 查询用户
     *
     * @param users 传入用户名和密码
     * @return 返回用户列表
     */
    Users selectUsers(Users users);

    /**
     * 添加用户
     *
     * @param users 传入用户名和密码
     * @return 受影响的行数
     */
    int insertUsers(Users users);
}
