package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 11:46
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

@WebServlet(urlPatterns = "/elServlet")
public class ElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //集合数据
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "zs", 23, "男", 0));
        list.add(new Student(2, "ls", 21, "女", 1));
        list.add(new Student(3, "rg", 8, "女", 1));
        list.add(new Student(4, "zx", 12, "男", 0));
        //存储数据
        request.setAttribute("list", list);
        //共享数据
        request.getRequestDispatcher("/list1.jsp").forward(request, response);
    }
}
