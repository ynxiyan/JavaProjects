package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/28 9:46
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
import java.util.List;

@WebServlet(urlPatterns = "/getStudentList")
public class GetStudentListServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //获取学生列表
        List<Student> studentList = studentService.list();
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(studentList);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }
}
