package com.ssm_maven.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
    //声明为bean
    @Bean
    public DataSource druidDataSource() {
        //创建DruidDataSource对象
        DruidDataSource druidDataSource = new DruidDataSource();
        //设置JDBC驱动
        druidDataSource.setDriverClassName(driver);
        //设置数据库连接源
        druidDataSource.setUrl(url);
        //设置用户名
        druidDataSource.setUsername(username);
        //设置密码
        druidDataSource.setPassword(password);
        //设置初始连接大小
        druidDataSource.setInitialSize(initialSize);
        //设置最小空闲连接大小
        druidDataSource.setMinIdle(minIdle);
        //设置最大活动连接大小
        druidDataSource.setMaxActive(maxActive);
        //设置最长等待时间
        druidDataSource.setMaxWait(maxWait);
        return druidDataSource;
    }

    /**
     * 设置Spring事务管理器
     *
     * @param druidDataSource 传入数据库连接池对象
     * @return 返回配置好的事务处理器
     */
    //声明为bean
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource druidDataSource) {
        //创建DataSourceTransactionManager对象
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        //设置数据库连接源对象的事务管理器为Spring事务管理器
        dataSourceTransactionManager.setDataSource(druidDataSource);
        return dataSourceTransactionManager;
    }
}
