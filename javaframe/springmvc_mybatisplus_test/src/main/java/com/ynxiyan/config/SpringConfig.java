package com.ynxiyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 10:52
 * @注释:
 */
@Configuration
@ComponentScan({"com.ynxiyan.service", "com.ynxiyan.dao"})
@PropertySource("classpath:druid.properties")
@EnableTransactionManagement
@Import({JdbcByDruidConfig.class, MyBaitsPlusConfig.class})
public class SpringConfig {
}
