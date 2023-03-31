package com.ynxiyan.springboot_mybatis_demo.controller;

import com.ynxiyan.springboot_mybatis_demo.model.User;
import com.ynxiyan.springboot_mybatis_demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: XIYAN
 * @Date: 2023/3/31 15:00
 * @注释:
 */
@RestController
@RequestMapping("/")
public class SystemController {
    @Autowired
    private UserService userService;

    //登录
    @GetMapping("login")
    public Result login(@Param("userName") String userName, @Param("password") String password) {
        User user = userService.login(userName, password);
        int code = user != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = user != null ? "登录成功" : "用户名或密码错误";
        return new Result(code, user, msg);
    }

    //注册
    @GetMapping("register")
    public Result register(@Param("userName") String userName, @Param("password") String password) {
        boolean register = userService.register(userName, password);
        int code = register ? Code.SAVE_OK : Code.SAVE_ERROR;
        String msg = register ? "注册成功" : "注册失败";
        return new Result(code, msg);
    }

    //修改用户密码
    @PutMapping("change")
    public Result change(String userName, String password) {
        boolean change = userService.change(userName, password);
        int code = change ? Code.SAVE_OK : Code.SAVE_ERROR;
        String msg = change ? "修改成功" : "修改失败";
        return new Result(code, msg);
    }
}
