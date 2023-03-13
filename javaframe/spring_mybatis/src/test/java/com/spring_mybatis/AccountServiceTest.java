package com.spring_mybatis;

import com.spring_mybatis.config.SpringConfig;
import com.spring_mybatis.service.AccountService;
import com.spring_mybatis.service.impl.AccounServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: XIYAN
 * @Date: 2023/3/13 9:10
 * @注释:
 */
//标记该类为spring的类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//载入spring的配置信息
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountService accountService = new AccounServiceImpl();

    @Test
    public void testFind() {
        System.out.println(accountService.findAll());
    }
}
