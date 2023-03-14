package com.springmvc_demo.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:48
 * @注释:Servlet容器初始化配置
 */
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    /**
     * 加载SpringMVC容器配置
     *
     * @return 返回初始化后的SpringMVC容器
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //创建AnnotationConfigWebApplicationContext对象
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        //注册SpringMVC容器
        applicationContext.register(com.springmvc_demo.controller.config.SpringMvcConfig.class);
        return applicationContext;
    }

    /**
     * 设置归属于SpringMVC处理的请求路径
     *
     * @return 返回所有请求路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 加载Spring容器配置
     *
     * @return
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
