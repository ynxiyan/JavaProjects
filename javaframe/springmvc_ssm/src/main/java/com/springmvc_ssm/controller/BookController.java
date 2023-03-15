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
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
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
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
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
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
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
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    /**
     * 查询全部图书信息
     *
     * @return
     */
    //GET请求
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
