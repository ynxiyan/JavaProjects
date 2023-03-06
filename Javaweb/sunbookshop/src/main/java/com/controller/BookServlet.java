package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.Author;
import com.model.Book;
import com.model.Page;
import com.model.Type;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 17:07
 * @注释:图书请求处理接口
 */
@WebServlet(urlPatterns = "/book/*")
public class BookServlet extends BasicServlet {
    private final BookService bookService = new BookServiceImpl();

    //获取出版社列表
    public void getAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取省份列表
        List<Author> authorList = bookService.getAuthor();
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(authorList);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }

    //获取图书分类列表
    public void getType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取省份列表
        List<Type> typeList = bookService.getType();
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(typeList);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }

    //获取图书列表
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取图书列表
        Page<Book> list = bookService.list(pageSize, currentPage);
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

    //通过图书名称查询图书
    public void getByBook_name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取用户名
        String book_name = request.getParameter("book_name");
        //解码
        book_name = new String(book_name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Book newBook = new Book();
        newBook.setBook_name(book_name);
        Page<Book> books = bookService.getBookByBook_name(pageSize, currentPage, newBook);
        String result = "fail";
        if (books.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(books);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过出版社查询图书
    public void getByAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取出版社序号
        String name = request.getParameter("name");
        Book newBook = new Book();
        newBook.setName(name);
        Page<Book> books = bookService.getBookByAuthor(pageSize, currentPage, newBook);
        String result = "fail";
        if (books.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(books);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //通过图书分类查询图书
    public void getByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页数据
        //当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //每页条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //获取图书分类序号
        String type = request.getParameter("type");
        Book newBook = new Book();
        newBook.setType(type);
        Page<Book> books = bookService.getBookByType(pageSize, currentPage, newBook);
        String result = "fail";
        if (books.getCount() != 0) {
            //将Java对象转为json字符串
            String jsonString = JSON.toJSONString(books);
            //将数据响应给前端axios
            response.getWriter().write(jsonString);
        } else {
            response.getWriter().write(result);
        }
    }

    //新增用户
    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book book = JSON.parseObject(readLine, Book.class);
        //调用新增方法并返回执行结果
        String result = "fail";
        if (bookService.addBook(book)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //批量修改图书状态
    public void outBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book[] BookList = JSON.parseObject(readLine, Book[].class);
        //调用修改方法并返回执行结果
        String result = "";
        for (int i = 0; i < BookList.length; i++) {
            result = "fail";
            if (bookService.outBookById(BookList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //批量删除图书
    public void delBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book[] BookList = JSON.parseObject(readLine, Book[].class);
        //调用删除方法并返回执行结果
        String result = "";
        for (int i = 0; i < BookList.length; i++) {
            result = "fail";
            if (bookService.delBookById(BookList[i])) {
                result = "succeed";
            }
            if ("fail".equals(result)) {
                break;
            }
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过图书序号删除图书
    public void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book book = JSON.parseObject(readLine, Book.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (bookService.delBookById(book)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过订单序号修改订单状态
    public void outBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book book = JSON.parseObject(readLine, Book.class);
        //调用删除方法并返回执行结果
        String result = "fail";
        if (bookService.outBookById(book)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }

    //通过图书序号更新图书信息
    public void upBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数(通过请求体)
        String readLine = request.getReader().readLine();
        //json字符串转java对象
        Book book = JSON.parseObject(readLine, Book.class);
        //调用更新方法并返回执行结果
        String result = "fail";
        if (bookService.upBook(book)) {
            result = "succeed";
        }
        //响应执行结果
        response.getWriter().write(result);
    }
}
