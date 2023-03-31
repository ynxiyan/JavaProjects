package com.ynxiyan.springboot_mybatis_demo.service.impl;

import com.ynxiyan.springboot_mybatis_demo.mapper.UserMapper;
import com.ynxiyan.springboot_mybatis_demo.model.User;
import com.ynxiyan.springboot_mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/31 13:32
 * @注释:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public User login(String userName, String password) {
        return userMapper.selectUserByUserNameAndPassword(userName, password);
    }

    @Override
    public List<User> getUserSwith(User user) {
        return userMapper.selectUserSwith(user);
    }

    @Override
    public List<User> getUserCondition(User user) {
        return userMapper.selectUserCondition(user);
    }

    @Override
    public boolean register(String userName, String password) {
        return userMapper.insertUserByUserNameAndPassword(userName, password) > 0;
    }

    @Override
    public boolean postUser(User user) {
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public boolean change(String userName, String password) {
        return userMapper.updateUserByUserName(userName, password) > 0;
    }

    @Override
    public boolean putUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUserById(int id) {
        return userMapper.deleteUserById(id) > 0;
    }

    @Override
    public boolean deleteUserByids(List<User> userList) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            list.add(userList.get(i).getId());
        }
        return userMapper.deleteUserByids(list) > 0;
    }
}
