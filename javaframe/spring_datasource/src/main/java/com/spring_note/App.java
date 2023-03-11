package com.spring_note;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class App {
    public static void main(String[] args) {
        //1.加载类路径下的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}