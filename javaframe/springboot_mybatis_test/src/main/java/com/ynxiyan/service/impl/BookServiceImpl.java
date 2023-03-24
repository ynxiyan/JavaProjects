package com.ynxiyan.service.impl;

import com.ynxiyan.dao.BookDao;
import com.ynxiyan.model.Book;
import com.ynxiyan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 14:29
 * @注释:
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBookAll() {
        return bookDao.selectBookAll();
    }
}
