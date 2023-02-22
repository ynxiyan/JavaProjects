package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/22 10:56
 * @注释:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String captcha = (String) request.getSession().getAttribute("captcha");
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (code.equalsIgnoreCase(captcha)) {
            if ("zs".equals(username) && "123".equals(password)) {
                System.out.println("T");
                Cookie userCookie = new Cookie("username", username);
                Cookie pwdCookie = new Cookie("password", password);
                userCookie.setMaxAge(7 * 24 * 60 * 60);
                pwdCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(userCookie);
                response.addCookie(pwdCookie);
            } else {
                System.out.println("F");
            }
        } else {
            System.out.println("F");
        }
    }
}
