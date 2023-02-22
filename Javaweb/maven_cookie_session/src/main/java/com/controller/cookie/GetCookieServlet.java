package com.controller.cookie; /**
 * @Author: XIYAN
 * @Date: 2023/2/22 9:48
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

@WebServlet(urlPatterns = "/getcookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie(数组)
        Cookie[] cookies = request.getCookies();
        //遍历cookie
        for (Cookie cookie : cookies) {
            //判断cookie的key
            if ("username".equals(cookie.getName())) {
                String value = cookie.getValue();
                //设置url解码
                URLEncoder.encode(value, "utf-8");
                break;
            }
        }
        //修改cookie
        Cookie newCookie = new Cookie("username", "zs");
        response.addCookie(newCookie);
    }
}
