package com.service;

import com.model.User;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 11:15
 * @注释:判断用户接口
 */
public interface UserService {
    /**
     * 登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    boolean enroll(User user);
}
