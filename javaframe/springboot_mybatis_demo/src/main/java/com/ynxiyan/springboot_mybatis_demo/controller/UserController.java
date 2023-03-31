package com.ynxiyan.springboot_mybatis_demo.controller;

import com.ynxiyan.springboot_mybatis_demo.model.User;
import com.ynxiyan.springboot_mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/31 13:40
 * @注释:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //查询所有用户列表
    @GetMapping
    public Result getUserList() {
        List<User> userList = userService.getUserAll();
        int code = userList != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = userList != null ? "查询成功" : "查询失败，请稍后重试";
        return new Result(code, userList, msg);
    }

    //单条件查询
    @GetMapping("/swith")
    public Result getUserSwith(User user) {
        List<User> userList = userService.getUserSwith(user);
        int code = userList != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = userList != null ? "查询成功" : "查询失败，请稍后重试";
        return new Result(code, userList, msg);
    }

    //多条件查询
    @GetMapping("/condition")
    public Result getUserCondition(User user) {
        List<User> userList = userService.getUserCondition(user);
        int code = userList != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = userList != null ? "查询成功" : "查询失败，请稍后重试";
        return new Result(code, userList, msg);
    }

    //新增用户信息
    @PostMapping
    public Result postUser(User user) {
        boolean postUser = userService.postUser(user);
        int code = postUser ? Code.SAVE_OK : Code.SAVE_ERROR;
        String msg = postUser ? "新增成功" : "新增失败";
        return new Result(code, msg);
    }

    //修改用户信息
    @PutMapping
    public Result putUser(User user) {
        boolean putUser = userService.putUser(user);
        int code = putUser ? Code.SAVE_OK : Code.SAVE_ERROR;
        String msg = putUser ? "修改成功" : "修改失败";
        return new Result(code, msg);
    }

    //通过id删除用户信息
    @DeleteMapping("/{id}")
    public Result deleteUserById(@PathVariable("id") int id) {
        boolean deleteUserById = userService.deleteUserById(id);
        int code = deleteUserById ? Code.DELETE_OK : Code.DELETE_ERROR;
        String msg = deleteUserById ? "删除成功" : "删除失败";
        return new Result(code, msg);
    }

    //批量删除用户信息
    @DeleteMapping
    public Result deleteUserByIds(@RequestBody List<User> userList) {
        boolean deleteUserByids = userService.deleteUserByids(userList);
        int code = deleteUserByids ? Code.DELETE_OK : Code.DELETE_ERROR;
        String msg = deleteUserByids ? "批量删除成功" : "批量删除失败";
        return new Result(code, msg);
    }
}
