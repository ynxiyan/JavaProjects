package com.hspedu.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 18:47
 * @注释:演示C3P0的使用
 */
public class C3P0 {
    //方式一
    @Test
    public void testC3P0_One() throws IOException, PropertyVetoException, SQLException {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件获取连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/resource/jdbc.properties"));
        //3.设置配置文件参数
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //4.给数据源comboPooledDataSource设置相关参数
        //注意连接管理是由comboPooledDataSource来管理
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //得到连接（getConnection()就是从DataSource实现）
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
    }

    //方式二
    /*
    前置操作
    1.将C3P0的配置文件放到src目录下
    2.设置配置文件的相关信息
     */
    @Test
    public void testC3P0_Two() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_jdbc");
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
    }
}
