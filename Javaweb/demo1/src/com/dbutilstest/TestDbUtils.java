package com.dbutilstest;

import com.model.Dogs;
import com.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 13:57
 * @注释:使用dbutils完成crud
 */
public class TestDbUtils {
    /**
     * 常用方法
     * update--插入、修改、删除，返回受影响的行数
     * insert--支持插入操作，获取自增列作为返回值
     * query--查询操作，自动处理ResultSet需要Handler的配合
     */
    //测试插入
    @Test
    public void testInsert() throws SQLException {
        //简化sql操作，结合Handler来处理常见的查询减少代码量
        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection connection = JdbcUtils.getConnection();
        String sql="insert into dogs values(null,?,?,?)";
        int update = queryRunner.update(connection, sql, "a", "公", 12);
        System.out.println(update);
        DbUtils.closeQuietly(connection);
    }
    //测试删除
    @Test
    public void testDelete() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql="delete from dogs where age>?";
        Connection connection = JdbcUtils.getConnection();
        int update = queryRunner.update(connection, sql, 10);
        System.out.println(update);
        DbUtils.closeQuietly(connection);
    }
    //测试查询（单条）
    @Test
    public void testSelect() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="select id,name,sex,age from dogs where id=?";
        //执行sql的时候需要Handler对象，参数为查询到对象的class
        BeanHandler<Dogs> dogsBeanHandler = new BeanHandler<>(Dogs.class);
        Dogs dogs = queryRunner.query(connection, sql, dogsBeanHandler, 4);
        System.out.println(dogs);
        DbUtils.closeQuietly(connection);
    }
    //测试查询（多条）
    @Test
    public void testSelectAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="select id,name,sex,age from dogs where id<?";
        BeanListHandler<Dogs> dogsBeanHandler = new BeanListHandler<>(Dogs.class);
        List<Dogs> dogsList = queryRunner.query(connection, sql, dogsBeanHandler, 10);
        dogsList.forEach(System.out::println);
        DbUtils.closeQuietly(connection);
    }
    //测试修改
    @Test
    public void testupDate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="update dogs set age=? where name=?";
        int update = queryRunner.update(connection, sql, 19, "f");
        System.out.println(update);
        DbUtils.closeQuietly(connection);
    }
    //测试聚合函数
    @Test
    public void testAggregate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        //最大值
        String maxSql="select max(age) from dogs";
        ScalarHandler<Object> handler = new ScalarHandler<>();
        int max = (Integer) queryRunner.query(connection, maxSql, handler);
        System.out.println(max);
        DbUtils.closeQuietly(connection);
    }
}
