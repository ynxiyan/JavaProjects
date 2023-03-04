package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/1 19:29
 * @注释:
 */

import com.alibaba.fastjson.JSON;
import com.model.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getByNameAndGrade")
public class GetByNameAndGradeServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String readLine = request.getReader().readLine();
        Student student = JSON.parseObject(readLine, Student.class);
        Student student1 = studentService.getStudentByNameAndGrade(student);
        String jsonString = JSON.toJSONString(student1);
        response.getWriter().write(jsonString);
    }
}
