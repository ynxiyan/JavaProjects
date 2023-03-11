package com.spring_note.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 14:29
 * @注释:
 */
public class JdbcConfig {
    //1.获取要管理的对象
    //2.添加@Bean，表示当前方法返回一个bean
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring_db");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        return druidDataSource;
    }
}
