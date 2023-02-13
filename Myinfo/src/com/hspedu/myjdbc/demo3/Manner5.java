package com.hspedu.myjdbc.demo3;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 14:53
 * @注释:方式五
 */
public class Manner5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //注册驱动（可省略）
        Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //操作数据库
        //创建news表
        String createSql = "create table news (id int not null primary key auto_increment," +
                "content varchar(100)" +
                ")";
        //向news表插入数据
        String insertSql = "insert into news values(null,'dyt')," +
                "(null,'det')," +
                "(null,'dst')," +
                "(null,'dsit')," +
                "(null,'dwt')";
        //更新news表里id为1的信息内容
        String updateSql = "update news set content='news' where id=1";
        //删除news表里id为3的记录
        String deleteSql = "delete from news where id=3";
        //创建Statement对象
        Statement statement = connection.createStatement();
        //执行sql语句
        statement.executeUpdate(createSql);
        int insert = statement.executeUpdate(insertSql);
        System.out.println(insert > 0 ? "sql执行成功" : "sql执行失败");
        int update = statement.executeUpdate(updateSql);
        System.out.println(update > 0 ? "sql执行成功" : "sql执行失败");
        int delete = statement.executeUpdate(deleteSql);
        System.out.println(delete > 0 ? "sql执行成功" : "sql执行失败");
        //关闭连接
        statement.close();
        connection.close();
    }
}
