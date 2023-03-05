package com.dao.impl;

import com.dao.OrderDao;
import com.model.Order;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 11:59
 * @注释:实现订单接口
 */
public class OrderDaoImpl extends BasicDao implements OrderDao {
    //公共查询方法
    //查询字段
    private final String select = "select orders.id,book_name,quantity,price,total,user_id,user.name,purchase_time,out_fig ";
    //查询总数
    private final String count = "count(1) as 'count' ";
    //表
    private final String from = "from orders,user ";

    @Override
    public int selectOrderByCount() {
        String sql = "select " + count + "from orders";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public List<Order> selectOrderAll(int begin, int pageSize) {
        String sql = select + from + "where orders.user_id=user.id limit ?,?";
        return selectList(Order.class, sql, begin, pageSize);
    }

    @Override
    public List<Order> selectOrderByName(int begin, int pageSize, Order order) {
        String sql = select + "," + count + from + "where user.name like ? and user.id=user_id order by orders.id limit ?,?";
        return selectList(Order.class, sql, "%" + order.getName() + "%", begin, pageSize);
    }

    @Override
    public List<Order> selectOrderByBook_name(int begin, int pageSize, Order order) {
        String sql = select + "," + count + from + "where book_name like ? and user.id=user_id order by orders.id limit ?,?";
        return selectList(Order.class, sql, "%" + order.getBook_name() + "%", begin, pageSize);
    }

    @Override
    public List<Order> selectOrderByPurchase_time(int begin, int pageSize, Order order) {
        String sql = select + "," + count + from + "where purchase_time like ? and user.id=user_id order by orders.id limit ?,?";
        return selectList(Order.class, sql, "%" + order.getPurchase_time() + "%", begin, pageSize);
    }

    @Override
    public int deleteOrderById(Order order) {
        String sql = "delete from orders where id=?";
        return update(sql, order.getId());
    }

    @Override
    public int updateOrderById(Order order) {
        String sql = "update orders set out_fig=1 where id=?";
        return update(sql, order.getId());
    }
}
