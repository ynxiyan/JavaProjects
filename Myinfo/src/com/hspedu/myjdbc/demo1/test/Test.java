package com.hspedu.myjdbc.demo1.test;

import com.hspedu.myjdbc.demo1.service.JdbcInterface;
import com.hspedu.myjdbc.demo1.service.impl.MysqlJdbcImpl;

/**
 * @Author: XIYAN
 * @Date: 2023/2/9 9:38
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        //创建jdbc对象(通过接口调用实现类，动态绑定[多态])
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        //创建Mysql连接
        jdbcInterface.getConnection();
        //对数据进行操作
        jdbcInterface.crud();
        //关闭Mysql连接
        jdbcInterface.close();
    }
}
