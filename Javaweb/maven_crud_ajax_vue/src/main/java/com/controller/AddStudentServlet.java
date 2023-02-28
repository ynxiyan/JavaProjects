package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/2/28 10:34
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
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/addStudent")
public class AddStudentServlet extends HttpServlet {
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
        //获取参数(通过请求体)
        BufferedReader reader = request.getReader();
        //读取一行数据
        String readLine = reader.readLine();
        //json字符串转java对象
        Student student = JSON.parseObject(readLine, Student.class);
        student.setStatues(1);
        //调用新增方法并返回执行结果
        String result = "添加失败";
        if (studentService.putStudent(student)) {
            result = "添加成功";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
