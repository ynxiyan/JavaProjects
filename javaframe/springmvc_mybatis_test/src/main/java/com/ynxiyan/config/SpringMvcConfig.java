package com.ynxiyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 9:46
 * @注释:SpringMVC配置
 */
@Configuration
@ComponentScan({"com.ynxiyan.controller","com.ynxiyan.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
