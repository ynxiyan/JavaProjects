package com.springmvc_ssm.controller;

import com.springmvc_ssm.model.Book;
import com.springmvc_ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 15:17
 * @注释:图书表现层功能实现
 */
//使用基于RESTful开发的业务层功能
@RestController
//请求路径前缀
@RequestMapping("/books")
public class BookController {
    //自动装配Service
    @Autowired
    private BookService bookService;

    /**
     * 新增图书信息
     *
     * @param book 传入图书信息
     * @return
     */
    //POST请求
    @PostMapping
    //@RequestBody表示接收的请求参数为json数据
    public Result save(@RequestBody Book book) {
        boolean save = bookService.save(book);
        return new Result(save ? Code.SAVE_OK : Code.SAVE_ERROR, save);
    }

    /**
     * 通过图书序号更新图书信息
     *
     * @param book 传入图书序号
     * @return
     */
    //PUT请求
    @PutMapping
    //@RequestBody表示接收的请求参数为json数据
    public Result update(@RequestBody Book book) {
        boolean update = bookService.update(book);
        return new Result(update ? Code.UPDATE_OK : Code.UPDATE_ERROR, update);
    }

    /**
     * 通过图书序号删除图书信息
     *
     * @param id 传入图书序号
     * @return
     */
    //DELETE请求
    @DeleteMapping("/{id}")
    //@PathVariable表示当前参数来自路径参数
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.delete(id);
        return new Result(delete ? Code.DELETE_OK : Code.DELETE_ERROR, delete);
    }

    /**
     * 通过图书序号查询图书信息
     *
     * @param id 传入图书序号
     * @return
     */
    //GET请求
    @GetMapping("/{id}")
    //@PathVariable表示当前参数来自路径参数
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERROR;
        String message = book != null ? "" : "查询失败，请重试";
        return new Result(code, book, message);
    }

    /**
     * 查询全部图书信息
     *
     * @return
     */
    //GET请求
    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERROR;
        String message = bookList != null ? "" : "查询失败，请重试";
        return new Result(code, bookList, message);
    }
}
