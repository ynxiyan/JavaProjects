package com.springmvc_demo.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 10:48
 * @注释:Servlet容器与Spring容器的初始化配置
 */
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取Spring容器的配置类
     *
     * @return 返回初始化后的Spring容器
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 获取SpringMVC容器的配置类
     *
     * @return 返回初始化后的SpringMVC容器
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 获取归属于SpringMVC处理的请求路径
     *
     * @return 返回所有请求路径
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 处理中文乱码
     *
     * @return 返回初始化后的中文乱码过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        //创建CharacterEncodingFilter对象
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        //设置字符编码为UTF-8
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }
}
//public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
//    /**
//     * 加载SpringMVC容器配置
//     *
//     * @return 返回初始化后的SpringMVC容器
//     */
//    protected WebApplicationContext createServletApplicationContext() {
//        //创建AnnotationConfigWebApplicationContext对象
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        //注册SpringMVC容器
//        applicationContext.register(SpringMvcConfig.class);
//        return applicationContext;
//    }
//
//    /**
//     * 设置归属于SpringMVC处理的请求路径
//     *
//     * @return 返回所有请求路径
//     */
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    /**
//     * 加载Spring容器配置
//     *
//     * @return 返回初始化后的Spring容器
//     */
//    protected WebApplicationContext createRootApplicationContext() {
//        //创建AnnotationConfigWebApplicationContext对象
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        //注册Spring容器
//        applicationContext.register(SpringConfig.class);
//        return applicationContext;
//    }
//}
