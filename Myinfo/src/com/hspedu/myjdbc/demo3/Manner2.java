package com.hspedu.myjdbc.demo3;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式二
 */
public class Manner2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类(动态加载，更加的灵活，减少依赖性)
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
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
