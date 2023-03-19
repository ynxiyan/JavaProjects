package com.ssm_maven.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 16:28
 * @注释:Spring整合MyBatis
 */
public class MyBatisConfig {
    /**
     * 初始化SqlSessionFactory并设置相关参数
     *
     * @param jdbcByDruidConfig 传入jdbcByDruid的数据库连接池对象
     * @return 返回初始化后的SqlSession对象
     */
    //声明为bean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(JdbcByDruidConfig jdbcByDruidConfig) {
        //创建SqlSessionFactoryBean对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置类型别名的包路径
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ssm_maven.model");
        //设置数据源
        sqlSessionFactoryBean.setDataSource(jdbcByDruidConfig.druidDataSource());
        return sqlSessionFactoryBean;
    }

    /**
     * 设置Mapper自动代理的映射文件
     *
     * @return 返回初始化后的Mapper自动代理映射对象
     */
    //声明为bean
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        //创建mapper自动代理对象
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置包扫描路径
        mapperScannerConfigurer.setBasePackage("com.ssm_maven.dao");
        return mapperScannerConfigurer;
    }
}
