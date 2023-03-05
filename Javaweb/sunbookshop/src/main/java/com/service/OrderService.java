package com.service;

import com.model.Order;
import com.model.Page;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:28
 * @注释:逻辑判断的订单接口
 */
public interface OrderService {
    /**
     * 逻辑判断订单列表
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @return 返回订单列表
     */
    Page<Order> list(int pageSize, int currentPage);

    /**
     * 逻辑判断用户名查询订单信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页数
     * @param order       传入用户名
     * @return 返回订单列表
     */

    Page<Order> getOrderByName(int pageSize, int currentPage, Order order);

    /**
     * 逻辑判断图书名称查询订单信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param order       传入图书名称
     * @return 返回订单列表
     */
    Page<Order> getOrderByBook_name(int pageSize, int currentPage, Order order);

    /**
     * 逻辑判断订购日期查询订单信息
     *
     * @param pageSize    传入每页分页数
     * @param currentPage 传入当前页
     * @param order       传入订购日期
     * @return 返回订单列表
     */
    Page<Order> getOrderByPurchase_time(int pageSize, int currentPage, Order order);

    /**
     * 逻辑判断订单序号删除订单信息
     *
     * @param order 传入订单序号
     * @return 返回执行结果
     */
    boolean delOrderById(Order order);

    /**
     * 逻辑判断订单序号更新订单状态
     *
     * @param order 传入订单序号
     * @return 返回执行结果
     */
    boolean outOrderById(Order order);
}
