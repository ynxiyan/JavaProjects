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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //将参数封装到对象
        User user = new User(username, password);
        User login = userService.login(user);
        //判断结果并执行操作
        if (login != null) {
            if ("1".equals(remember)) {
                Cookie userCookie = new Cookie("username", username);
                Cookie pwdCookie = new Cookie("password", password);
                userCookie.setMaxAge(7 * 24 * 60 * 60);
                pwdCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(userCookie);
                response.addCookie(pwdCookie);
            }
            request.getSession().setAttribute("user", user);
            System.out.println(user);
            request.getRequestDispatcher("/list").forward(request, response);
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
