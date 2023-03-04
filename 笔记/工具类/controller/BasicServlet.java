package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/1 20:09
 * @注释:优化Servlet
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置网页请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/json;charset=utf-8");
        //获取路径
        String requestURI = req.getRequestURI();
        //截取最后一个/的路径
        int lastIndexOf = requestURI.lastIndexOf('/');
        String substring = requestURI.substring(lastIndexOf + 1);
        //获取当前访问的子类Servlet字节码的Class对象
        Class<? extends BasicServlet> aClass = this.getClass();
        try {
            //获取Class子类对象的公共的方法（方法名，参数）
            Method method = aClass.getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
