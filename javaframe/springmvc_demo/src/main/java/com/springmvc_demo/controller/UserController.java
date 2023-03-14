package com.springmvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:41
 * @注释:
 */
//声明控制器
@Controller
//设置当前控制器的请求路径前缀
@RequestMapping("/user")
public class UserController {
    //设置当前操作的访问路径
    @RequestMapping("/save")
    //设置当前操作的返回值类型
    @ResponseBody
    public String save(@RequestBody String name) {
        System.out.println(name);
        return "{'model':'springmvc'}";
    }
}
