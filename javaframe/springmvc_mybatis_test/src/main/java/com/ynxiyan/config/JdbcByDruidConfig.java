package com.ynxiyan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:13
 * @注释:Spring整合JdbcByDruido配置
 */
public class JdbcByDruidConfig {
    @Value("${driverClassName}")
    //mysql驱动
    private String driver;
    @Value("${url}")
    //数据库链接
    private String url;
    @Value("${username}")
    //用户名
    private String username;
    @Value("${password}")
    //密码
    private String password;

    /**
     * 配置Druid数据库连接池
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    /**
     * Spring事务管理器配置
     *
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
