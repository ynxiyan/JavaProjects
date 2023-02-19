package com.servlet; /**
 * @Author: XIYAN
 * @Date: 2023/2/19 15:44
 * @注释:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forwords2")
public class forwordsServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("2");
        System.out.println(request.getAttribute("user"));
        request.removeAttribute("user");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
