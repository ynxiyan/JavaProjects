package com.ynxiyan.springboot_mybatis_demo.service;

import com.ynxiyan.springboot_mybatis_demo.model.User;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/31 13:28
 * @注释:
 */
public interface UserService {
    List<User> getUserAll();

    User login(String userName, String password);

    List<User> getUserSwith(User user);

    List<User> getUserCondition(User user);

    boolean register(String userName, String password);

    boolean postUser(User user);

    boolean change(String userName, String password);

    boolean putUser(User user);

    boolean deleteUserById(int id);

    boolean deleteUserByids(List<User> userList);
}
