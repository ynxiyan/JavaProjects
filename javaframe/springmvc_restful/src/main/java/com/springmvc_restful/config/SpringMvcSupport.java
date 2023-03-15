package com.springmvc_restful.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 11:38
 * @注释:SpringMVC静态资源过滤
 */
//声明该类为Spring的配置类
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    /**
     * 静态资源过滤器
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/**时，走/pages/路径
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
