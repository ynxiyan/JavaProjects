package com.service;

import com.model.Author;
import com.model.Book;
import com.model.Page;
import com.model.Type;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 17:00
 * @注释:逻辑判断的图书接口
 */
public interface BookService {
    /**
     * 逻辑判断出版社列表
     *
     * @return 返回出版社列表
     */
    List<Author> getAuthor();

    /**
     * 逻辑判断图书分类列表
     *
     * @return 返回图书分类列表
     */
    List<Type> getType();

    /**
     * 逻辑判断图书列表
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @return 返回图书列表
     */
    Page<Book> list(int pageSize, int currentPage);

    /**
     * 逻辑判断图书名称查询图书信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @param book        传入图书名称
     * @return 返回图书列表
     */

    Page<Book> getBookByBook_name(int pageSize, int currentPage, Book book);

    /**
     * 逻辑判断出版社序号查询用户信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param book        传入出版社序号
     * @return 返回图书列表
     */
    Page<Book> getBookByAuthor(int pageSize, int currentPage, Book book);

    /**
     * 逻辑判断图书分类序号查询图书信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param book        传入图书分类序号
     * @return 返回用户列表
     */
    Page<Book> getBookByType(int pageSize, int currentPage, Book book);

    /**
     * 逻辑判断新增图书信息
     *
     * @param book 传入图书对象
     * @return 返回执行结果
     */
    boolean addBook(Book book);

    /**
     * 逻辑判断图书序号更新图书状态
     *
     * @param book 传入图书序号
     * @return 返回执行结果
     */
    boolean outBookById(Book book);

    /**
     * 逻辑判断图书序号删除图书信息
     *
     * @param book 传入图书序号
     * @return 返回执行结果
     */
    boolean delBookById(Book book);

    /**
     * 逻辑判断图书序号更新图书信息
     *
     * @param book 传入图书序号和图书信息
     * @return 返回执行结果
     */
    boolean upBook(Book book);
}
