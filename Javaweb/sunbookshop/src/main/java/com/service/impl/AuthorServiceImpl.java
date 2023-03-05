package com.service.impl;

import com.dao.AuthorDao;
import com.dao.impl.AuthorDaoImpl;
import com.model.Author;
import com.model.Page;
import com.service.AuthorService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:23
 * @注释:实现逻辑判断的作者接口
 */
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public Page<Author> list(int pageSize, int currentPage) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //获取分页后的数据
        List<Author> list = authorDao.selectAuthorAll(begin, pageSize);
        //获取数据总数
        int count = authorDao.selectAuthorByCount();
        return new Page<>(count, list);
    }
}
