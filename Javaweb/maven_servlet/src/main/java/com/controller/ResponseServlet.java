package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/19 16:26
 * @注释:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Response1")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应状态码
        response.setStatus(302); //302(重定向)
        //设置响应的网页类型
        //response.setHeader("Content-Type","text/html;charset=ISO-8859-1");
        response.setContentType("text/html;charset=ISO-8859-1");
        response.sendRedirect("/maven_servlet/Response2");
    }
}
