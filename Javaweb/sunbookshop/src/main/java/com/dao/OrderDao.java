package com.dao;

import com.model.Order;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:14
 * @注释:订单接口
 */
public interface OrderDao {
    /**
     * 查询订单总数据
     *
     * @return 返回订单总数
     */
    int selectOrderByCount();

    /**
     * 查询订单列表
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @return 返回订单列表
     */
    List<Order> selectOrderAll(int begin, int pageSize);

    /**
     * 通过用户名查询订单信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param order    传入用户名
     * @return 返回订单列表
     */
    List<Order> selectOrderByName(int begin, int pageSize, Order order);

    /**
     * 通过图书名称查询订单信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param order    传入图书名称
     * @return 返回订单列表
     */
    List<Order> selectOrderByBook_name(int begin, int pageSize, Order order);

    /**
     * 通过订购日期查询订单信息
     *
     * @param begin    传入开始位置
     * @param pageSize 传入每页条数
     * @param order    传入订购日期
     * @return 返回订单列表
     */
    List<Order> selectOrderByPurchase_time(int begin, int pageSize, Order order);

    /**
     * 通过订单序号删除订单信息
     *
     * @param order 传入订单序号
     * @return 返回受影响的行数
     */
    int deleteOrderById(Order order);

    /**
     * 通过订单序号更新订单状态
     *
     * @param order 传入订单序号
     * @return 返回受影响的行数
     */
    int updateOrderById(Order order);
}
