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
import java.nio.charset.StandardCharsets;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:26
 * @注释:出版社请求处理接口
 */
@WebServlet(urlPatterns = "/author/*")
public class AuthorServlet extends BasicServlet {
    private final AuthorService authorService = new AuthorServiceImpl();

    //获取出版社列表
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取出版社列表
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

    //通过出版社名称查询出版社
    public void getByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取出版社名称
        String name = request.getParameter("name");
        //解码
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Author newAuthor = new Author();
        newAuthor.setName(name);
        Page<Author> authors = authorService.getAuthorByName(pageSize, currentPage, newAuthor);
        String result = "fail";
        if (authors.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(authors);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过省份和城市查询出版社
    public void getByProvince_city(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取省份序号
        String province_id = request.getParameter("province");
        //获取城市序号
        String city_id = request.getParameter("city");
        Author newAuthor = new Author();
        newAuthor.setProvince(province_id);
        newAuthor.setCity(city_id);
        Page<Author> authors = authorService.getAuthorByProvince_city(pageSize, currentPage, newAuthor);
        String result = "fail";
        if (authors.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(authors);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过联系方式查询出版社
    public void getByPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取联系方式
        String phone = request.getParameter("phone");
        Author newAuthor = new Author();
        newAuthor.setPhone(phone);
        Page<Author> authors = authorService.getAuthorByPhone(pageSize, currentPage, newAuthor);
        String result = "fail";
        if (authors.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(authors);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过联系人查询出版社
    public void getByContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取联系人
        String contact = request.getParameter("contact");
        //解码
        contact = new String(contact.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Author newAuthor = new Author();
        newAuthor.setContact(contact);
        Page<Author> authors = authorService.getUserByContact(pageSize, currentPage, newAuthor);
        String result = "fail";
        if (authors.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(authors);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //新增出版社
    public void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Author author = JSON.parseObject(readLine, Author.class);
        //调用新增方法并返回执行结果
        String result = "fail";
        if (authorService.addAuthor(author)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //批量删除出版社
    public void delAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Author[] authorList = JSON.parseObject(readLine, Author[].class);
        //调用删除方法并返回执行结果
        String result = "";
        for (int i = 0; i < authorList.length; i++) {
            result = "fail";
            if (authorService.delAuthorById(authorList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过出版社序号删除出版社
    public void delAuthorById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Author author = JSON.parseObject(readLine, Author.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (authorService.delAuthorById(author)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过出版社序号更新出版社信息
    public void upAuthorById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Author author = JSON.parseObject(readLine, Author.class);
        //调用更新方法并返回执行结果
        String result = "fail";
        if (authorService.upAuthorById(author)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
