package com.controller.session; /**
 * @Author: XIYAN
 * @Date: 2023/2/22 11:22
 * @注释:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Session
        HttpSession session = request.getSession();
        //存储Session
        session.setAttribute("username", "zs");
        //设置session的超时时间（以秒位单位，超时自动销毁）
        session.setMaxInactiveInterval(30000000);
        //销毁session
        session.invalidate();
        //获取
        Object username = request.getSession().getAttribute("username");
    }
}
