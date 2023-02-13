package com.hspedu.myjdbc.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/10 15:08
 * @注释:使用PerparedStatement创建、插入、修改、删除、查询
 */
public class PerparedStatementDml {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        //创建Properties对象并获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //注册Driver驱动
        Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //操作数据库
        //创建admin表
        String createSql = "create table admin (id int not null primary key auto_increment,username varchar(10),pwd varchar(10))";
        int createTable = connection.prepareStatement(createSql).executeUpdate();
        //向admin表插入数据
        String insertSql = "insert into admin values(null,?,?)";
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String pwd = scanner.nextLine();
        PreparedStatement insPs = connection.prepareStatement(insertSql);
        insPs.setString(1, username);
        insPs.setString(2, pwd);
        int insertData = insPs.executeUpdate();
        System.out.println(insertData > 0 ? "插入数据成功" : "执行失败！");
        //修改admin表中username为tom的记录
        String updateSql = "update admin set username=? where username=?";
        System.out.print("请输入需要修改的用户名：");
        String oldname = scanner.nextLine();
        System.out.print("请输入新的用户名：");
        String newname = scanner.nextLine();
        PreparedStatement updPs = connection.prepareStatement(updateSql);
        updPs.setString(1, newname);
        updPs.setString(2, oldname);
        int updateData = updPs.executeUpdate();
        System.out.println(updateData > 0 ? "更新数据成功" : "执行失败！");
        //删除admin中的一条记录
        String deleteSql = "delete from admin where id=?";
        System.out.print("请输入需要删除的id：");
        int id = scanner.nextInt();
        PreparedStatement delPs = connection.prepareStatement(deleteSql);
        delPs.setInt(1, id);
        int deleteData = delPs.executeUpdate();
        System.out.println(deleteData > 0 ? "删除记录成功" : "执行失败！");
        //查询admin表中的所有记录
        String selectSql = "select id,username,pwd from admin";
        ResultSet resultSet = connection.prepareStatement(selectSql).executeQuery();
        while (resultSet.next()) {
            int ids = resultSet.getInt(1);
            String usernames = resultSet.getString(2);
            String pwds = resultSet.getString(3);
            System.out.println(ids + "\t" + usernames + "\t" + pwds);
        }
    }
}
