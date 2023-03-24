package com.ynxiyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:26
 * @注释:Spring配置
 */
@Configuration
@ComponentScan({"com.ynxiyan.service", "com.ynxiyan.dao"})
@PropertySource("classpath:druid.properties")
@EnableTransactionManagement
@Import({JdbcByDruidConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
