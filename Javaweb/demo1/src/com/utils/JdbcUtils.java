package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/11 10:07
 * @注释:完成mysql数据库的连接与关闭
 */
public class JdbcUtils {
    //1.定义属性（需定义成static静态属性）
    //用户名
    private static String user;
    //密码
    private static String password;
    //数据库连接点
    private static String url;
    //驱动
    private static String driver;

    //2.初始化（static）
    static {
        //创建Properties对象
        Properties properties = new Properties();
        try {
            //读取配置文件信息
            properties.load(new FileInputStream("demo1/src/com/resource/mysql.properties"));
            //获取用户名
            user = properties.getProperty("user");
            //获取密码
            password = properties.getProperty("password");
            //获取数据库连接点
            url = properties.getProperty("url");
            //获取驱动
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            /*
            注意：在实际开发中，需要这样处理
            1.将编译异常转成远行时异常
            2.这样调用者可以选择捕获该异常，也可以选择默认处理该异常，比较方便
             */
            throw new RuntimeException(e);
        }
    }

    //3.连接数据库，返回一个Connection连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //4.关闭连接（如果需要关闭连接，就传入需要关闭的对象，否则传入null）
    /*
    可能需要关闭的对象：
    1.关闭ResultSet结果集
    2.关闭Sataement或PreparedStatement
    3.关闭Connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        //判断需要关闭的对象是否为空
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
