package com.spring_note.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 13:49
 * @注释:
 */
//spring的配置类
@Configuration
//包扫描
//@ComponentScan("com.spring_note")
@Import(JdbcConfig.class)
public class SpringConfig {
}
