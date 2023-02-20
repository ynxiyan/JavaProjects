package com;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 11:28
 * @注释:
 */
public class TestUser {
    @Test
    public void testSelectUser() {
        User user = new User("zs", "123");
        //User user = new User("ss", "890");
        UserService userService = new UserServiceImpl();
        if (userService.login(user) != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
//        if (userService.enroll(user)) {
//            System.out.println("注册成功");
//        } else {
//            System.out.println("注册失败");
//        }
    }
}
