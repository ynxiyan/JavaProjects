package com.hspedu.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 19:25
 * @注释:演示Druid连接池
 */
public class TestDruid {
    /*
    前置操作
    1.导入Druid.jar
    2.将配置文件导入到src目录下
     */
    @Test
    public void test() throws Exception {
        //创建Properties对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        //创建一个指定对象的数据库连接池(Druid连接池)
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
