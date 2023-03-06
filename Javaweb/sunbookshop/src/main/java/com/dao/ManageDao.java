package com.dao;

import com.model.Manage;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 16:54
 * @注释:管理员接口
 */
public interface ManageDao {
    /**
     * 通过用户名和密码查询管理员
     *
     * @param manage 传入用户名和密码
     * @return 返回查询结果
     */
    Manage selectMange(Manage manage);

    /**
     * 通过用户名修改密码
     *
     * @param manage 传入用户名和密码
     * @return 返回受影响的行数
     */
    int updateByName(Manage manage);
}
