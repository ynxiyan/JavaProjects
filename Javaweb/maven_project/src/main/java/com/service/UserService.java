package com.service;

import com.model.User;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 11:15
 * @注释:用户接口
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

    /**
     * 判断用户是否存在
     *
     * @param user 传入用户名
     * @return 返回执行结果
     */
    boolean info(User user);
}
