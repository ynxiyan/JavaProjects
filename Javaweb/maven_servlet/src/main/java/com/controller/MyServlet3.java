package com.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 14:59
 * @注释:
 */
@WebServlet(urlPatterns = "/servlet3", loadOnStartup = 1)
public class MyServlet3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //ServletConfig的三个作用：
        //1.获取xml中servlet程序的别名
        servletConfig.getServletName();
        //2.获取初始化参数
        servletConfig.getInitParameter("user");
        //3.获取ServletContext对象(servlet的上下文，存储当前项目或servlet的一些信息)
        servletConfig.getServletContext();
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * servlet中执行功能的方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //根据请求的不同，获取请求参数会有不同
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取当前请求的请求方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet(servletRequest, servletResponse);
        } else if ("POST".equals(method)) {
            doPost(servletRequest, servletResponse);
        }
    }

    /**
     * POST请求执行方法
     *
     * @param servletRequest
     * @param servletResponse
     */
    private void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("POST");
    }

    /**
     * GET请求执行方法
     *
     * @param servletRequest
     * @param servletResponse
     */
    private void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("GET");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
