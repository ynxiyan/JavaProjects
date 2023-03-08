package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.Users;
import com.service.UsersService;
import com.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 18:35
 * @注释:用户请求处理
 */
@WebServlet(urlPatterns = "/users/*")
public class UsersServlet extends BasicServlet {
    private final UsersService usersService = new UsersServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String readLine = request.getReader().readLine();
        Users users = JSON.parseObject(readLine, Users.class);
        Users login = usersService.login(users);
        String result = "fail";
        if (login != null) {
            request.getSession().setAttribute("username", login.getUsername());
            if (request.getSession().getAttribute("username") != null) {
                result = "succeed";
            }
        } else {
            response.getWriter().write(result);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String readLine = request.getReader().readLine();
        Users users = JSON.parseObject(readLine, Users.class);
        String result = "fail";
        if (usersService.register(users)) {
            result = "succeed";
        }
        response.getWriter().write(result);
    }
}
