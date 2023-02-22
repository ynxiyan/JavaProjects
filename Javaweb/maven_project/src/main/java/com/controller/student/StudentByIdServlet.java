package com.controller.student; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 19:13
 * @注释:通过id查询学生的控制器
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

@WebServlet(urlPatterns = "/get")
public class StudentByIdServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student();
        student.setId(id);
        Student studentById = studentService.getStudentById(student);
        if (studentById != null) {
            request.setAttribute("studentById", studentById);
            request.getRequestDispatcher("/upstudent.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
