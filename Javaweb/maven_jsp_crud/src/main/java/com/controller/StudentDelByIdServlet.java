package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 16:37
 * @注释:通过id删除学生的控制器
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

@WebServlet(urlPatterns = "/del")
public class StudentDelByIdServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("test/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student();
        student.setId(id);
        if (studentService.delStudentById(student)) {
            response.sendRedirect("/maven_jsp_crud/list");
        } else {
            response.sendRedirect("/maven_jsp_crud/error.jsp");
        }
    }
}
