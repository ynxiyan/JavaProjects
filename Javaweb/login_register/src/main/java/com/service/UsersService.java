package com.service;

import com.model.Users;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 17:25
 * @注释:逻辑判断用户的接口
 */
public interface UsersService {
    /**
     * 登录
     *
     * @param users 传入用户名和密码
     * @return 返回用户列表
     */
    Users login(Users users);

    /**
     * 注册
     *
     * @param users 传入用户对象
     * @return 返回执行结果
     */

    boolean register(Users users);
}
