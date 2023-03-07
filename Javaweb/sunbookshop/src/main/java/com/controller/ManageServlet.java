package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.Manage;
import com.service.ManageService;
import com.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 20:58
 * @注释:管理员请求处理接口
 */
@WebServlet(urlPatterns = "/manage/*")
public class ManageServlet extends BasicServlet {
    private final ManageService manageService = new ManageServiceImpl();

    //比对原始密码与用户输入是否一致
    public void contrast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求体读取一行数据
        String readLine = request.getReader().readLine();
        //将json字符串转为Java对象
        Manage manage = JSON.parseObject(readLine, Manage.class);
        //调用登录方法
        Manage login = manageService.login(manage);
        //判断用户是否存在
        String result = "fail";
        if (login != null) {
            result = "succeed";
        } else {
            //响应执行结果
            response.getWriter().write(result);
        }
    }

    //更新密码
    public void chahge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求体读取一行数据
        String readLine = request.getReader().readLine();
        //将json字符串转为Java对象
        Manage manage = JSON.parseObject(readLine, Manage.class);
        //调用更新方法并返回执行结果
        String result = "fail";
        if (manageService.change(manage)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
        //清空session对象
        request.getSession().invalidate();
    }
}
