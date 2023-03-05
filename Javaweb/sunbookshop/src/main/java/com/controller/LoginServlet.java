package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/2 16:48
 * @注释:后台管理登录处理接口
 */

import com.alibaba.fastjson.JSON;
import com.model.Manage;
import com.service.ManageService;
import com.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求体读取一行数据
        String readLine = request.getReader().readLine();
        //将json字符串转为Java对象
        Manage manage = JSON.parseObject(readLine, Manage.class);
        //调用登录方法
        Manage login = manageService.login(manage);
        //判断用户是否存在
        String result = "fail";
        if (login != null) {
            //存储Session对象
            request.getSession().setAttribute("manage", login.getName());
            if (request.getSession().getAttribute("manage") != null) {
                result = "succeed";
            }
        } else {
            //响应执行结果
            response.getWriter().write(result);
        }
    }
}
