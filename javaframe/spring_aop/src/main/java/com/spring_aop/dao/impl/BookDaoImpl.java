package com.spring_aop.dao.impl;

import com.spring_aop.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: XIYAN
 * @Date: 2023/3/13 9:51
 * @注释:
 */
@Repository
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }

    public void update() {
        System.out.println("book dao update ...");
    }
}
