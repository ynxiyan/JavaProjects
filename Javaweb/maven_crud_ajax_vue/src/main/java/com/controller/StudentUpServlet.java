package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 19:51
 * @注释:
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

@WebServlet(urlPatterns = "/update")
public class StudentUpServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int ordered = Integer.parseInt(request.getParameter("ordered"));
        Student student = new Student();
        student.setId(id);
        student.setStu_name(name);
        student.setGrade_name(grade);
        student.setAge(age);
        student.setAddress(address);
        student.setOrdered(ordered);
        if (studentService.upStudent(student)) {
            response.sendRedirect(request.getContextPath() + "/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
