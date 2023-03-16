package com.springmvc_interceptor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 16:12
 * @注释:Spring配置
 */
//声明该类为Spring的配置类
@Configuration
//规定包扫描
@ComponentScan({"com.springmvc_interceptor.service", "com.springmvc_interceptor.dao"})
//导入Druid的配置文件信息
//@PropertySource("classpath:druid.properties")
//开启注解式事务驱动
//@EnableTransactionManagement
//开启注解式AOP开发
//@EnableAspectJAutoProxy
//导入其他配置类
//@Import({JdbcByDruidConfig.class, MyBatisConfig.class})
public class SpringConfig {

}
