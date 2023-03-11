package com.spring_note.dao.impl;

import com.spring_note.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 11:36
 * @注释:
 */
//组件
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
