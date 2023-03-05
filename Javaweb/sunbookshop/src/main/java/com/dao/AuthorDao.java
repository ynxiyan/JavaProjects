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
     * 查询作者总数
     *
     * @return 返回作者总数
     */
    int selectAuthorByCount();

    /**
     * 查询作者列表
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @return 返回作者列表
     */
    List<Author> selectAuthorAll(int begin, int pageSize);
}
