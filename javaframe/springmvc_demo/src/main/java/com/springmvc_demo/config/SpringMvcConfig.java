package com.springmvc_demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:45
 * @注释:SpringMVC配置
 */
//声明该类为springmvc的配置类
@Configuration
//规定包扫描
@ComponentScan("com.springmvc_demo")
public class SpringMvcConfig {
}
