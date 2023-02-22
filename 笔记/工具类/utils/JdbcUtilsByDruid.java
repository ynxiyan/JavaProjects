package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 19:41
 * @注释:基于Druid数据库连接池的工具类
 */
public class JdbcUtilsByDruid {
    //创建连接池对象
    private static DataSource dataSource;

    //在静态代码块初始化代码
    static {
        //创建Properties对象
        Properties properties = new Properties();
        //读取配置文件信息
        try {
            properties.load(new FileInputStream("src/main/resources/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //编写colose方法
    /*
    注：
    在数据库连接池技术中并不是真正的关闭连接而是把使用的Connection对象放回连接池
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {

                resultSet.close();

            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
