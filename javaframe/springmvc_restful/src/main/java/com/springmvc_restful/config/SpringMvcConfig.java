package com.springmvc_restful.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:45
 * @注释:SpringMVC的配置
 */
//声明该类为springmvc的配置类
@Configuration
//规定包扫描
@ComponentScan({"com.springmvc_restful.controller", "com.springmvc_restful.config"})
//开启json数据转java对象
@EnableWebMvc
public class SpringMvcConfig {
}
