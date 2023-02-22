package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/20 15:24
 * @注释:用户注册处理
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
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String code = (String) request.getSession().getAttribute("code");
        //封装参数到对象
        User user = new User(username, password);
        //判断验证码是否一致
        if (code.equalsIgnoreCase(checkCode)) {
            //判断用户名是否存在
            if (userService.info(user)) {
                request.setAttribute("usermsg", "用户名已存在");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            } else {
                //调用注册方法
                if (userService.enroll(user)) {
                    request.setAttribute("msg", "注册成功请登录");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    request.setAttribute("errmsg", "注册失败内部错误");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
            }
        } else {
            request.setAttribute("codemsg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
