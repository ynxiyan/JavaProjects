package com.spring_note;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring_note.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class Main {
    public static void main(String[] args) {
        //创建容器，并读取配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        BookService bookService = applicationContext.getBean(BookService.class);
//        bookDao.save();
//        bookService.save();
        DruidDataSource druidDataSource = applicationContext.getBean(DruidDataSource.class);
        System.out.println(druidDataSource);
    }
}