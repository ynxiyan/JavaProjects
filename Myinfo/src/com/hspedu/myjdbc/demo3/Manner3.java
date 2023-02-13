package com.hspedu.myjdbc.demo3;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式三
 */
public class Manner3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类(动态加载，更加的灵活，减少依赖性)
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //定义jdbc连接地址、用户名和密码
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        String user = "root";
        String password = "123456";
        //注册Driver驱动
        DriverManager.registerDriver(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
