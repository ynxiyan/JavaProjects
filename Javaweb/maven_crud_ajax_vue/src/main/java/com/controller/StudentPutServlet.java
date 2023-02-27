package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 18:42
 * @注释:添加学生的控制器
 */

import com.model.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/put")
public class StudentPutServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int ordered = Integer.parseInt(request.getParameter("ordered"));
        Student student = new Student(null, name, grade, age, address, ordered, 1);
        if (studentService.putStudent(student)) {
            request.getRequestDispatcher("/list").forward(request, response);
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
