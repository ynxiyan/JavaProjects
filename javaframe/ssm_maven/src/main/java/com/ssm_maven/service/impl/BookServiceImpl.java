package com.ssm_maven.service.impl;

import com.ssm_maven.dao.BookDao;
import com.ssm_maven.model.Book;
import com.ssm_maven.service.BookService;
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
        return bookDao.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
