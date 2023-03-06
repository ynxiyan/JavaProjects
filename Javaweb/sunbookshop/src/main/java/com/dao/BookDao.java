package com.dao;

import com.model.Author;
import com.model.Book;
import com.model.Type;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 16:52
 * @注释:图书接口
 */
public interface BookDao {
    /**
     * 查询图书总数据
     *
     * @return 返回图书总数
     */
    int selectBookByCount();

    /**
     * 查询出版社列表
     *
     * @return 返回出版社列表
     */
    List<Author> selectByAuthor();

    /**
     * 查询图书分类列表
     *
     * @return 返回图书分类列表
     */
    List<Type> selectByType();

    /**
     * 查询图书列表
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @return 返回图书列表
     */
    List<Book> selectBookAll(int begin, int pageSize);

    /**
     * 通过图书名称查询图书信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param book     传入图书名称
     * @return 返回图书列表
     */
    List<Book> selectBookByBook_name(int begin, int pageSize, Book book);

    /**
     * 通过出版社序号查询图书信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param book     传入图书序号
     * @return 返回图书列表
     */
    List<Book> selectBookByAuthor(int begin, int pageSize, Book book);

    /**
     * 通过图书分类序号查询图书信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param book     传入图书分类序号
     * @return 返回图书列表
     */
    List<Book> selectBookByType(int begin, int pageSize, Book book);

    /**
     * 新增图书信息
     *
     * @param book 传入图书对象
     * @return 返回受影响的行数
     */
    int insertBook(Book book);

    /**
     * 通过图书序号更新图书状态
     *
     * @param book 传入图书序号
     * @return 返回受影响的行数
     */
    int updateBookById(Book book);

    /**
     * 通过图书序号删除图书信息
     *
     * @param book 传入图书序号
     * @return 返回受影响的行数
     */
    int deleteBookById(Book book);

    /**
     * 通过图书序号更新图书信息
     *
     * @param book 传入图书序号和图书信息
     * @return 返回受影响的行数
     */
    int updateBook(Book book);
}
