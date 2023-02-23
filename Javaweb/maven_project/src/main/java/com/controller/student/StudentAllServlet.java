package com.controller.student; /**
 * @Author: XIYAN
 * @Date: 2023/2/21 16:05
 * @注释:查询全部学生的控制器
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
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class StudentAllServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用list()方法
        List<Student> list = studentService.list();
        //存储数据
        request.setAttribute("list", list);
        //转发（携带数据）
        request.getRequestDispatcher("/student_list.jsp").forward(request, response);
    }
}
