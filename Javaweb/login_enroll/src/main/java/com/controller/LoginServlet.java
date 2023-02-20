package com.controller;
/**
 * @Author: XIYAN
 * @Date: 2023/2/20 13:57
 * @注释:用户登录处理
 */

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = request.getParameter("password");
        password = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //将参数封装到对象
        User user = new User(username, password);
        User login = userService.login(user);
        PrintWriter writer = response.getWriter();
        //判断结果并执行操作
        if (login != null) {
            writer.write("成功");
        } else {
            writer.write("失败");
        }
    }
}
