package com.spring_auto.service.ipml;

import com.spring_auto.dao.BookDao;
import com.spring_auto.service.BookService;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 9:13
 * @注释:
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
