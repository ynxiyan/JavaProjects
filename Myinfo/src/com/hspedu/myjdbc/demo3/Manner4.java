package com.hspedu.myjdbc.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式四
 */
public class Manner4 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类并在加载时自动完成Driver驱动的注册
        Class.forName("com.mysql.jdbc.Driver");
        //定义jdbc连接地址、用户名和密码
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        String user = "root";
        String password = "123456";
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
