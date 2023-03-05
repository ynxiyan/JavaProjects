package com.service.impl;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.model.Order;
import com.model.Page;
import com.service.OrderService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 12:19
 * @注释:实现逻辑判断的订单接口
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();

    /**
     * 处理条件查询后的数据条数及订单列表
     *
     * @param list 传入需要处理的订单列表
     * @return 返回处理后订单列表
     */
    public Page<Order> aggregate(List<Order> list) {
        //计算数据总数
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getCount();
        }
        return new Page(count, list);
    }

    @Override
    public Page<Order> list(int pageSize, int currentPage) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //获取分页后的数据
        List<Order> list = orderDao.selectOrderAll(begin, pageSize);
        //获取数据总数
        int count = orderDao.selectOrderByCount();
        return new Page<>(count, list);
    }

    @Override
    public Page<Order> getOrderByName(int pageSize, int currentPage, Order order) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(orderDao.selectOrderByName(begin, pageSize, order));
    }

    @Override
    public Page<Order> getOrderByBook_name(int pageSize, int currentPage, Order order) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(orderDao.selectOrderByBook_name(begin, pageSize, order));
    }

    @Override
    public Page<Order> getOrderByPurchase_time(int pageSize, int currentPage, Order order) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        return aggregate(orderDao.selectOrderByPurchase_time(begin, pageSize, order));
    }

    @Override
    public boolean delOrderById(Order order) {
        return orderDao.deleteOrderById(order) > 0;
    }

    @Override
    public boolean outOrderById(Order order) {
        return orderDao.updateOrderById(order) > 0;
    }
}
