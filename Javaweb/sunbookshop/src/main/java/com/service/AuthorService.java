package com.service;

import com.model.Author;
import com.model.Page;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:21
 * @注释:逻辑判断的作者接口
 */
public interface AuthorService {
    /**
     * 逻辑判断作者列表
     *
     * @param pageSize
     * @param currentPage
     * @return
     */
    Page<Author> list(int pageSize, int currentPage);

    /**
     * 逻辑判断出版社名称查询出版社信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @param author      传入出版社名称
     * @return 返回出版社列表
     */

    Page<Author> getAuthorByName(int pageSize, int currentPage, Author author);

    /**
     * 逻辑判断省份序号和城市序号查询出版社信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param author      传入省份序号和城市序号
     * @return 返回出版社列表
     */
    Page<Author> getAuthorByProvince_city(int pageSize, int currentPage, Author author);

    /**
     * 逻辑判断联系方式查询出版社信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param author      传入联系方式
     * @return 返回出版社列表
     */
    Page<Author> getAuthorByPhone(int pageSize, int currentPage, Author author);

    /**
     * 逻辑判断联系人查询出版社信息
     *
     * @param pageSize    传入每页页数
     * @param currentPage 传入当前页
     * @param author      传入联系人
     * @return 返回出版社列表
     */
    Page<Author> getUserByContact(int pageSize, int currentPage, Author author);

    /**
     * 逻辑判断新增出版社信息
     *
     * @param author 传入出版社对象
     * @return 返回执行结果
     */
    boolean addAuthor(Author author);

    /**
     * 逻辑判断出版社序号删除出版社信息
     *
     * @param author 传入出版社序号
     * @return 返回执行结果
     */
    boolean delAuthorById(Author author);

    /**
     * 逻辑判断出版社序号更新出版社信息
     *
     * @param author 传入出版社序号和出版社信息
     * @return 返回执行结果
     */
    boolean upAuthorById(Author author);
}
