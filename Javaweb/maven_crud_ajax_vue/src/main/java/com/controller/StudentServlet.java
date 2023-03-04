package com.controller; /**
 * @Author: XIYAN
 * @Date: 2023/3/2 9:34
 * @注释:
 */

import com.alibaba.fastjson.JSON;
import com.model.Page;
import com.model.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/student/*")
public class StudentServlet extends BasicServlet {
    private StudentService studentService = new StudentServiceImpl();

    //分页查询
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取学生列表
        Page<Student> list = studentService.list(pageSize, currentPage);
        System.out.println(list);
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(list);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }
}
