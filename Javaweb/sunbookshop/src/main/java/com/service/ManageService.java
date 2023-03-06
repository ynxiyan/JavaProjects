package com.service;

import com.model.Manage;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 17:01
 * @注释:逻辑判断的管理员接口
 */
public interface ManageService {
    /**
     * 登录
     *
     * @param manage
     * @return
     */
    Manage login(Manage manage);

    /**
     * 逻辑判断通过用户名修改密码
     *
     * @param manage 传入用户名和密码
     * @return 返回执行结果
     */
    boolean change(Manage manage);
}
