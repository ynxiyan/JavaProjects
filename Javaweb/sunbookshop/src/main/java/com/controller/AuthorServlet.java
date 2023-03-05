package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.Author;
import com.model.Page;
import com.service.AuthorService;
import com.service.impl.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:26
 * @注释:作者请求处理接口
 */
@WebServlet(urlPatterns = "/author/*")
public class AuthorServlet extends BasicServlet {
    private final AuthorService authorService = new AuthorServiceImpl();

    //获取作者列表
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取作者列表
        Page<Author> list = authorService.list(pageSize, currentPage);
        String result = "fail";
        if (list.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(list);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }
}
