package com.mapper;

import com.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/9 11:06
 * @注释:
 */
public interface UserMapper {
    /**
     * 查询用户列表
     *
     * @return 返回用户列表
     */
    List<User> selectAll();

    User selectById(User user);
}
