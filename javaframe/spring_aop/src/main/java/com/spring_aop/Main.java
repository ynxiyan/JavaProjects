package com.spring_aop;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();
        bookDao.update();
    }
}