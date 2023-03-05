package com.dao.impl;

import com.dao.AuthorDao;
import com.model.Author;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:13
 * @注释:实现作者接口
 */
public class AuthorDaoImpl extends BasicDao implements AuthorDao {
    private final String select = "select id,name,author_introduction ";
    private final String count = "count(1) as 'count' ";
    private final String from = "from author ";

    @Override
    public int selectAuthorByCount() {
        String sql = "select " + count + " from author";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public List<Author> selectAuthorAll(int begin, int pageSize) {
        String sql = select + from + "limit ?,?";
        return selectList(Author.class, sql, begin, pageSize);
    }
}
