package com.springmvc_demo.service.impl;

import com.springmvc_demo.model.User;
import com.springmvc_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 14:09
 * @注释:
 */
@Service
public class UserServiceImpl implements UserService {
    public void save(User user) {
        System.out.println("user service ...");
    }
}
