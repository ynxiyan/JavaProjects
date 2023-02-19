package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/19 9:55
 * @注释:
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        //1. 获取web.xml中配置的上下文参数	context-param
        servletContext.getInitParameter("users");
        //2. 获取当前的工作路径
        servletContext.getContextPath();
        //3. 获取工程部署后在服务器硬盘上的绝对路径
        servletContext.getRealPath("/");
        //4. 可以像Map集合一样存储数据
        servletContext.setAttribute("user", "zs");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
