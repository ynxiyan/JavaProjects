package com.dao.impl;


import com.utils.JdbcUtilsByDruid;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 15:28
 * @注释:BaseDao是所有针对数据库操作的基本类 需要在里面设置一些通用方法来解决增删查改代码重复的问题
 */
public class BasicDao {
    //定义QueryRunner类型的属性，值为对象
    QueryRunner queryRunner = new QueryRunner();

    /**
     * 该方法是进行增删改的通用方法
     * @param sql     传入需要操作的sql
     * @param params  传入需要使用的值
     * @return 返回受影响的行数
     */
    public int update(String sql, Object... params) {
        //打开链接
        Connection connection = null;
        try {
            connection = JdbcUtilsByDruid.getConnection();
            //执行成功返回受影响的行数
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭连接
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 根据传入的sql查询单个对象的方法
     * @param clazz    查询后要返回的对象
     * @param sql      查询单个对象的sql
     * @param params   sql参数
     * @return         查询到的对象
     * @param <T>      根据calzz得到一个泛型将这个泛型作为对象返回（属性与表字段相同）
     */
    public <T>T selectOne(Class<T> clazz,String sql,Object ... params) {
        Connection connection = null;
        try {
            connection = JdbcUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     *
     * @param clazz     查询后要返回的对象
     * @param sql       查询的sql
     * @param params    sql参数
     * @return          查询到的对象
     * @param <T>       根据calzz得到一个泛型将这个泛型作为对象返回（属性与表字段相同）
     */
    public <T>List<T> selectList(Class<T> clazz,String sql,Object ... params) {
        Connection connection = null;
        try {
            connection = JdbcUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 通用的聚合函数查询方法
     * @param sql       传入的sql
     * @param params    sql参数
     * @return          返回查询到的值
     */
    public Object selectAggregate(String sql,Object ... params) {
        Connection connection = null;
        try {
            connection = JdbcUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }
}