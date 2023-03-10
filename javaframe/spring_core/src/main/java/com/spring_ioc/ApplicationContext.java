package com.spring_ioc;

import com.spring_ioc.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class ApplicationContext {
    public static void main(String[] args) {
        //创建IoC容器并获取配置信息
        org.springframework.context.ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.sout();
        userDao.sout();
    }
}