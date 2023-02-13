package com.hspedu.myjdbc.demo5;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/10 9:20
 * @注释:java演示SQL注入
 */
public class Statement {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        //使用next()时当收到空格或者'时自动结束
        //如果希望看到SQL注入，这里需要使用nextLine()
        String name = input.nextLine();
        System.out.print("请输入密码：");
        String pwd = input.nextLine();
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
        java.sql.Statement statement = connection.createStatement();
        //5.操作数据库
        //查询actor表
        String selectSql = "select name,pwd from admin where name='" + name + "'and pwd='" + pwd + "'";
        //6.执行sql语句并返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(selectSql);
        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
        //8.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
