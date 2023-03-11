package com.spring_disposition;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class App {
    public static void main(String[] args) {
        //创建IoC容器并获取配置信息
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        //BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
        //bookDao.save();
        //UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.sout();
        //userDao.sout();
    }
}