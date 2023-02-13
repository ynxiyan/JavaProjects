package com.hspedu.myjdbc.demo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 16:06
 * @注释:eclect语句返回ResultSet并取出结果集
 */
public class Result {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //1.通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //2.注册驱动（可省略）
        Class.forName(driver);
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //4.创建Statement对象
        Statement statement = connection.createStatement();
        //5.操作数据库
        //查询actor表
        String selectSql = "select id,name,sex,borndate from actor";
        //6.执行sql语句并返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(selectSql);
        //7.使用while循环取出数据   next--让光标下移，当没有数据行时返回false
        while (resultSet.next()) {
            //获取该行的第一列数据~~~
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);
        }
        //8.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
