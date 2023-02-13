package com.hspedu.myjdbc.demo2.test;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 10:10
 * @注释:第一个Jdbc程序，完成简单的操作
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        /*
        前置操作：
        创建一个文件夹（名字随意）
        将jar包拷贝到该目录下，右键添加到库
         */
        //1.注册驱动(创建Driver对象）
        Driver driver = new Driver();
        //2.得到连接（本质：socket连接）
        //"jdbc连接协议://主机或IP地址:端口号/数据库名"
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        //3.将用户名和密码放入Properties对象中
        Properties properties = new Properties();
        /*
        说明：
        user和password是规定好的不能修改
         */
        //设置用户
        properties.setProperty("user", "root");
        //设置密码
        properties.setProperty("password", "123456");
        //4.连接数据库
        Connection connection = driver.connect(url, properties);
        //5.操作数据库
        //创建sql语句
        String sql = "insert into actor values(null,'张三','男','2000-09-07','110')";
        //执行sql语句并返回结果对象
        Statement statement = connection.createStatement();
        //返回受影响的行数(返回大于0的数字即执行成功，返回0则执行失败)
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "sql执行成功" : "sql执行失败");
        //6.关闭连接
        statement.close();
        connection.close();
    }
}
