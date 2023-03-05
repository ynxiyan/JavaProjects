package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/23 10:59
 * @注释:后台管理退出登录处理接口
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清空session对象
        request.getSession().invalidate();
        String result = "fail";
        //判断用户是否为登录状态
        if (request.getSession().getAttribute("manage") == null) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
