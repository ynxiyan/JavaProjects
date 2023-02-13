package com.hspedu.myjdbc.demo1.service;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 9:27
 * @注释:规定的jdbc接口[模拟]
 */
public interface JdbcInterface {
    /**
     * 连接
     *
     * @return
     */
    Object getConnection();

    /**
     * 数据的增删改查
     */
    void crud();

    /**
     * 关闭连接
     */
    void close();
}
