package com.spring_mybatis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 16:12
 * @注释:Spring配置
 */
@Configuration
@ComponentScan("com.spring_mybatis")
@PropertySource("druid.properties")
@Import({JdbcByDruidConfig.class, MyBatisConfig.class})
public class SpringConfig {

}
