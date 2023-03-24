package com.ynxiyan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: XIYAN
 * @Date: 2023/3/24 13:21
 * @注释:跨域处理
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 跨域处理配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域路径
        CorsRegistration cors = registry.addMapping("/**");

        // 可访问的外部域
        cors.allowedOrigins("*");
        // 支持跨域用户凭证
        //cors.allowCredentials(true);
        //cors.allowedOriginPatterns("*");
        // 设置 header 能携带的信息
        cors.allowedHeaders("*");
        // 支持跨域的请求方法
        cors.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
        // 设置跨域过期时间，单位为秒
        cors.maxAge(3600);
    }
}