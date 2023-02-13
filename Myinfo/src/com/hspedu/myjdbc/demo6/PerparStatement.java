package com.hspedu.myjdbc.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/10 9:20
 * @注释:java演示SQL注入
 */
public class PerparStatement {
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
        //4.操作数据库
        //查询actor表(sql语句里的？相当于占位符)
        String selectSql = "select name,pwd from admin where name=? and pwd=?";
        //5.创建PerparedStatement对象(PerparedStatement对象实现了PerparedStatement接口的实现类的对象)
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        //6.设置占位符（？）的位置及获取的字段名
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        //6.执行sql语句并返回单个ResultSet对象
        /*
        执行select语句使用executeQuery()
        执行update、insert、delete语句使用executeUpdate()
         */
        //executeQuery()里的参数无需再处理
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
        //8.关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
