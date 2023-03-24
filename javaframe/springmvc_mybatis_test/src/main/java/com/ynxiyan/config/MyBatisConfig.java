package com.ynxiyan.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:19
 * @注释:Spring整合MyBatis配置
 */
public class MyBatisConfig {
    /**
     * 初始化SqlSessionFactoryBean
     *
     * @param jdbcByDruidConfig
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(JdbcByDruidConfig jdbcByDruidConfig) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ynxiyan.model");
        sqlSessionFactoryBean.setDataSource(jdbcByDruidConfig.dataSource());
        return sqlSessionFactoryBean;
    }

    /**
     * Mapper映射配置
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ynxiyan.dao");
        return mapperScannerConfigurer;
    }
}
