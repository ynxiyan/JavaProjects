package com.service.impl;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.model.Author;
import com.model.Book;
import com.model.Page;
import com.model.Type;
import com.service.BookService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 17:02
 * @注释:实现逻辑判断的图书接口
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    /**
     * 处理条件查询后的数据条数及图书列表
     *
     * @param list 传入需要处理的图书列表
     * @return 返回处理后图书列表
     */
    public Page<Book> aggregate(List<Book> list) {
        //计算数据总数
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getCount();
        }
        return new Page(count, list);
    }

    @Override
    public List<Author> getAuthor() {
        return bookDao.selectByAuthor();
    }

    @Override
    public List<Type> getType() {
        return bookDao.selectByType();
    }

    @Override
    public Page<Book> list(int pageSize, int currentPage) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //获取分页后的数据
        List<Book> list = bookDao.selectBookAll(begin, pageSize);
        //获取数据总数
        int count = bookDao.selectBookByCount();
        return new Page<>(count, list);
    }

    @Override
    public Page<Book> getBookByBook_name(int pageSize, int currentPage, Book book) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(bookDao.selectBookByBook_name(begin, pageSize, book));
    }

    @Override
    public Page<Book> getBookByAuthor(int pageSize, int currentPage, Book book) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(bookDao.selectBookByAuthor(begin, pageSize, book));
    }

    @Override
    public Page<Book> getBookByType(int pageSize, int currentPage, Book book) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(bookDao.selectBookByType(begin, pageSize, book));
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.insertBook(book) > 0;
    }

    @Override
    public boolean outBookById(Book book) {
        return bookDao.updateBookById(book) > 0;
    }

    @Override
    public boolean delBookById(Book book) {
        return bookDao.deleteBookById(book) > 0;
    }

    @Override
    public boolean upBook(Book book) {
        return bookDao.updateBook(book) > 0;
    }
}
