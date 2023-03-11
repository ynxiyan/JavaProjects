package com.spring_mybatis;

import com.spring_mybatis.config.SpringConfig;
import com.spring_mybatis.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @Author: ${USER}
 * @Date: ${DATE} ${TIME}
 * @注释:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //获取Spring配置信息
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean
        AccountService accountService = applicationContext.getBean(AccountService.class);
        System.out.println(accountService.findAll());
    }
}