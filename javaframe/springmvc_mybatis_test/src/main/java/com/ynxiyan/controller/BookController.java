package com.ynxiyan.controller;

import com.ynxiyan.model.Book;
import com.ynxiyan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:40
 * @注释:
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Result getBookAll() {
        List<Book> bookList = bookService.getBookAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERROR;
        String msg = bookList != null ? "查询成功" : "查询失败";
        return new Result(code, bookList, msg);
    }
}
