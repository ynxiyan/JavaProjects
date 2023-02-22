package com.controller.cookie; /**
 * @Author: XIYAN
 * @Date: 2023/2/22 9:36
 * @注释:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //模拟存储cookie
//        Cookie userCookie = new Cookie("username","zs");
//        Cookie pwdCookie = new Cookie("password","123");
//        //通知客户端保存cookie
//        response.addCookie(userCookie);
//        response.addCookie(pwdCookie);
//        //创建cookie
//        Cookie cookie = new Cookie("username", "zs");
//        //设置cookie的存活时间
//        //存活7天
//        cookie.setMaxAge(7 * 24 * 60 * 60);
//        response.addCookie(cookie);
        String username = "张三";
        //设置url编码
        URLEncoder.encode("utf-8");
        //设置cooike
        Cookie cookie = new Cookie("username", username);
        //设置存活时间
        cookie.setMaxAge(7 * 24 * 60 * 60);
        //设置cookie的有效路径
        cookie.setPath(request.getContextPath() + "get");
        //通知客户端保存cooike
        response.addCookie(cookie);
    }
}
