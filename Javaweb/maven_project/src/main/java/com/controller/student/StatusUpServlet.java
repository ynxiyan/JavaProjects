package com.controller.student; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 20:12
 * @注释:修改学生状态的控制器
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

@WebServlet(urlPatterns = "/status")
public class StatusUpServlet extends HttpServlet {
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
        if (studentById.getStatus() == 1) {
            studentById.setStatus(0);
        } else {
            studentById.setStatus(1);
        }
        if (studentService.status(studentById)) {
            response.sendRedirect("/maven_jsp_crud/list");
        } else {
            response.sendRedirect("/maven_jsp_crud/error.jsp");
        }
    }
}
