package com.dao;

import com.model.Author;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:11
 * @注释:作者接口
 */
public interface AuthorDao {
    /**
     * 查询出版社总数
     *
     * @return 返回出版社总数
     */
    int selectAuthorByCount();

    /**
     * 查询出版社列表
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @return 返回作者列表
     */
    List<Author> selectAuthorAll(int begin, int pageSize);

    /**
     * 通过出版社查询出版社信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param author   传入出版社名称
     * @return 返回出版社列表
     */
    List<Author> selectAuthorByName(int begin, int pageSize, Author author);

    /**
     * 通过省份序号和城市序号查询出版社信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param author   传入省份序号和城市序号
     * @return 返回出版社列表
     */
    List<Author> selectAuthorByProvince_city(int begin, int pageSize, Author author);

    /**
     * 通过联系方式查询出版社信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param author   传入电话号码
     * @return 返回用户列表
     */
    List<Author> selectAuthorByPhone(int begin, int pageSize, Author author);

    /**
     * 通过联系人查询出版社信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param author   传入联系人
     * @return 返回出版社列表
     */
    List<Author> selectAuthorByContact(int begin, int pageSize, Author author);

    /**
     * 新增出版社信息
     *
     * @param author 传入出版社对象
     * @return 返回受影响的行数
     */
    int insertAuthor(Author author);

    /**
     * 通过出版社序号删除出版社信息
     *
     * @param author 传入出版社序号
     * @return 返回受影响的行数
     */
    int deleteAuthorById(Author author);

    /**
     * 通过出版社序号更新出版社信息
     *
     * @param author 传入出版社序号和出版社信息
     * @return 返回受影响的行数
     */
    int updateAuthorById(Author author);
}
