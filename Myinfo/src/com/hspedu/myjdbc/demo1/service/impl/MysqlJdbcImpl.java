package com.hspedu.myjdbc.demo1.service.impl;

import com.hspedu.myjdbc.demo1.service.JdbcInterface;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 9:32
 * @注释:Mysql实现jdbc接口
 */
public class MysqlJdbcImpl implements JdbcInterface {
    /**
     * 连接
     *
     * @return
     */
    @Override
    public Object getConnection() {
        return "得到Mysql连接";
    }

    /**
     * 数据的增删改查
     */
    @Override
    public void crud() {
        System.out.println("实现数据的增删改查");
    }

    /**
     * 关闭连接
     */
    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
