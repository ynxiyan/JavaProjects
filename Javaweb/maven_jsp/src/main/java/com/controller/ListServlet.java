package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 14:39
 * @注释:
 */

import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/listServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "zs", 23, "男", 0));
        list.add(new Student(2, "ls", 21, "女", 1));
        list.add(new Student(3, "rg", 8, "女", 1));
        list.add(new Student(4, "zx", 12, "男", 0));
        request.setAttribute("list", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
