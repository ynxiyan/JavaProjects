package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/20 15:24
 * @注释:
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

@WebServlet(urlPatterns = "/enrollServlet")
public class EnrollServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收参数
        String username = request.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = request.getParameter("password");
        password = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //封装参数到对象
        User user = new User(username, password);
        //调用注册方法
        boolean enroll = userService.enroll(user);
        PrintWriter writer = response.getWriter();
        if (enroll) {
            writer.write("成功");
        } else {
            writer.write("失败");
        }
    }
}
