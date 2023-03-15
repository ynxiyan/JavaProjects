package com.springmvc_ssm.service.impl;

import com.springmvc_ssm.dao.BookDao;
import com.springmvc_ssm.model.Book;
import com.springmvc_ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 15:16
 * @注释:图书业务层接口实现类
 */
@Service
public class BookServiceImpl implements BookService {
    //自动装配Repository
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
