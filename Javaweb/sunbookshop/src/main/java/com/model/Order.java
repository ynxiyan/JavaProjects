package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 11:40
 * @注释:订单实体
 */
@Data
public class Order {
    //订单序号
    private Integer id;
    //图书名称
    private String book_name;
    //购买数量
    private Integer quantity;
    //单价
    private double price;
    //总价
    private double total;
    //用户序号
    private String user_id;
    //用户名
    private String name;
    //订购日期
    private String purchase_time;
    //出库标志
    private Integer out_fig;
    //查询总数
    private Integer count;

    public Order() {
    }

    public Order(Integer id, String book_name, Integer quantity, double price, double total, String user_id, String name, String purchase_time, Integer out_fig, Integer count) {
        this.id = id;
        this.book_name = book_name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.user_id = user_id;
        this.name = name;
        this.purchase_time = purchase_time;
        this.out_fig = out_fig;
        this.count = count;
    }
}
