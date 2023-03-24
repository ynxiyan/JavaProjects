package com.ynxiyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 10:55
 * @注释:
 */
@Configuration
@ComponentScan({"com.ynxiyan.controller","com.ynxiyan.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
