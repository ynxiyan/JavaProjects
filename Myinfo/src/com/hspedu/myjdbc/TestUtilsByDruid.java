package com.hspedu.myjdbc;

import com.hspedu.utils.JdbcUtils;
import com.hspedu.utils.JdbcUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/11 13:51
 * @注释:演示如何使用JdbcUtilsByDruid工具类，执行SQL语句
 */
public class TestUtilsByDruid {
    public static void main(String[] args) {
        //upDate();
        //inSert();
        //delEte();
        selEct();
    }

    /**
     * 更新记录
     */
    public static void upDate() {
        //1.创建Connection对象
        Connection connection = null;
        //2.创建PeoparedStatement对象
        PreparedStatement preparedStatement = null;
        //3.数据库操作
        String updateSql = "update actor set name=? where id=?";
        try {
            //4.得到连接
            connection = JdbcUtilsByDruid.getConnection();
            //5.预处理SQL语句
            preparedStatement = connection.prepareStatement(updateSql);
            //6.处理占位符
            preparedStatement.setString(1, "志昂");
            preparedStatement.setInt(2, 2);
            //执行SQL语句并返回影响行数
            int update = preparedStatement.executeUpdate();
            System.out.println(update > 0 ? "更新记录成功" : "执行失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //7.关闭连接
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 插入记录
     */
    public static void inSert() {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String insertSql = "insert into admin values(null,?,?)";
        try {
            connection = JdbcUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(insertSql);
            boolean flag = true;
            while (flag) {
                System.out.print("请输入用户名：");
                String user = scanner.nextLine();
                preparedStatement.setString(1, user);
                System.out.print("请输入密码");
                String pwd = scanner.nextLine();
                preparedStatement.setString(2, pwd);
                int insert = preparedStatement.executeUpdate();
                System.out.println(insert > 0 ? "插入记录成功" : "执行失败");
                System.out.print("是否继续添加记录(y/n)：");
                String w = scanner.next();
                if (!"y".equals(w)) {
                    flag = false;
                }
                String dubug = scanner.nextLine();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 删除记录
     */
    public static void delEte() {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String deleteSql = "delete from admin where username=?";
        try {
            connection = JdbcUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(deleteSql);
            System.out.print("请输入需要删除的用户名：");
            String user = scanner.nextLine();
            preparedStatement.setString(1, user);
            int delete = preparedStatement.executeUpdate();
            System.out.println(delete > 0 ? "删除记录成功" : "执行失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 查询记录
     */
    public static void selEct() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectSql = "select id,username,pwd from admin";
        try {
            connection = JdbcUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String pwd = resultSet.getString(3);
                System.out.println(id + "\t" + username + "\t" + pwd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
