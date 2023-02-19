package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: XIYAN
 * @Date: 2023/2/19 11:07
 * @注释:
 */
@WebServlet(urlPatterns = "/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        String name = req.getParameter("name");
        //给浏览器响应一个网页
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().write(name);
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        StringBuffer requestURL = req.getRequestURL();
        String requestURI = req.getRequestURI();
        String queryString = req.getQueryString();
        String remoteHost = req.getRemoteHost();
        String header = req.getHeader("User-Agent");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post");
//        //获取字符输入流信息（纯文本）
//        BufferedReader reader = req.getReader();
//        //读取数据
//        System.out.println(reader.readLine());
//        //获取字节输入流信息（文件）
//        ServletInputStream inputStream = req.getInputStream();
//        Map<String, String[]> parameterMap = req.getParameterMap();
        String user = req.getParameter("user");
//        String[] lists = req.getParameterValues("list");
        req.setCharacterEncoding("utf-8");
        user = new String(user.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
