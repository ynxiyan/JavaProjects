package com.ssm_maven.config;

import com.ssm_maven.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:45
 * @注释:SpringMVC的配置
 */
//声明该类为springmvc的配置类
@Configuration
//规定包扫描
@ComponentScan("com.ssm_maven.controller")
//开启json数据转java对象
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    //自动装配SpringMVC容器bean（拦截器）
    @Autowired
    private ProjectInterceptor interceptor;

    /**
     * 静态资源过滤器
     *
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/**时，走/pages/路径
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        //当访问/js/**时，走/js/路径
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        //当访问/css/**时，走/css/路径
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    /**
     * 动态资源拦截器
     *
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //当访问/books、/books/*时，拦截
        registry.addInterceptor(interceptor).addPathPatterns("/books", "/books/*");
    }
}
