package com.spring_mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 16:25
 * @注释:Spring整合JdbcByDruid
 */
public class JdbcByDruidConfig {
    //注册驱动
    @Value("${driverClassName}")
    private String driver;
    //数据库连接源
    @Value("${url}")
    private String url;
    //用户名
    @Value("${username}")
    private String username;
    //密码
    @Value("${password}")
    private String password;
    //初始连接大小
    @Value("${initialSize}")
    private int initialSize;
    //最小空闲连接大小
    @Value("${minIdle}")
    private int minIdle;
    //最大活动连接大小
    @Value("${maxActive}")
    private int maxActive;
    //最长等待时间
    @Value("${maxWait}")
    private int maxWait;

    /**
     * 初始化jdbcByDruid数据源连接池
     *
     * @return 返回初始化后的DruidDataSource对象
     */
    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        return druidDataSource;
    }
}
