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

    /**
     * 处理条件查询后的数据条数及出版社列表
     *
     * @param list 传入需要处理的出版社列表
     * @return 返回处理后出版社列表
     */
    public Page<Author> aggregate(List<Author> list) {
        //计算数据总数
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getCount();
        }
        return new Page(count, list);
    }

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

    @Override
    public Page<Author> getAuthorByName(int pageSize, int currentPage, Author author) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(authorDao.selectAuthorByName(begin, pageSize, author));
    }

    @Override
    public Page<Author> getAuthorByProvince_city(int pageSize, int currentPage, Author author) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(authorDao.selectAuthorByProvince_city(begin, pageSize, author));
    }

    @Override
    public Page<Author> getAuthorByPhone(int pageSize, int currentPage, Author author) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(authorDao.selectAuthorByPhone(begin, pageSize, author));
    }

    @Override
    public Page<Author> getUserByContact(int pageSize, int currentPage, Author author) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(authorDao.selectAuthorByContact(begin, pageSize, author));
    }

    @Override
    public boolean addAuthor(Author author) {
        return authorDao.insertAuthor(author) > 0;
    }

    @Override
    public boolean delAuthorById(Author author) {
        return authorDao.deleteAuthorById(author) > 0;
    }

    @Override
    public boolean upAuthorById(Author author) {
        return authorDao.updateAuthorById(author) > 0;
    }
}
