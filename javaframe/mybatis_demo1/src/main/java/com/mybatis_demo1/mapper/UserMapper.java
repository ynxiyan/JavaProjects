package com.mybatis_demo1.mapper;

import com.mybatis_demo1.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/30 9:43
 * @注释:
 */

public interface UserMapper {
    List<User> selectUserAll();
}
