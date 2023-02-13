package com.hspedu.myjdbc.demo3;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:43
 * @注释:方式一
 */
public class Manner1 {
    public static void main(String[] args) throws SQLException {
        //获取Driver实现类对象
        Driver driver = new Driver();
        //定义jdbc连接地址
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        //创建Properties对象
        Properties properties = new Properties();
        //设置用户名
        properties.setProperty("user", "root");
        //设置密码
        properties.setProperty("password", "123456");
        //连接数据库
        Connection connect = driver.connect(url, properties);
    }
}
