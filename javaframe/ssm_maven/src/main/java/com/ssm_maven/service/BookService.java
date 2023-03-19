package com.ssm_maven.service;

import com.ssm_maven.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 15:15
 * @注释:图书业务层接口
 */
//使用Spring管理事务
@Transactional
public interface BookService {
    /**
     * 新增图书信息
     *
     * @param book 传入图书对象
     * @return 返回执行结果
     */
    boolean save(Book book);

    /**
     * 通过图书序号修改图书信息
     *
     * @param book 传入图书序号
     * @return 返回执行结果
     */
    boolean update(Book book);

    /**
     * 通过图书序号删除图书信息
     *
     * @param id 传入图书序号
     * @return 返回执行结果
     */
    boolean delete(Integer id);

    /**
     * 通过图书序号查询图书信息
     *
     * @param id 传入图书序号
     * @return 返回图书信息
     */
    Book getById(Integer id);

    /**
     * 查询全部图书信息
     *
     * @return 返回图书信息列表
     */
    List<Book> getAll();
}
