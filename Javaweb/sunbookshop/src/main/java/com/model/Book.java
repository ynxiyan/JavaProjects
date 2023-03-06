package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 16:48
 * @注释:图书实体
 */
@Data
public class Book {
    //图书序号
    private Integer id;
    //图书名称
    private String book_name;
    //出版社序号
    private String author_id;
    //出版社名称
    private String name;
    //图书分类序号
    private String type_id;
    //图书分类
    private String type;
    //ISBN
    private String ISBN;
    //价格
    private double price;
    //库存
    private Integer inventory;
    //出库标志
    private Integer in_flg;
    //查询总数
    private Integer count;

    public Book() {
    }

    public Book(Integer id, String book_name, String author_id, String name, String type_id, String type, String ISBN, double price, Integer inventory, Integer in_flg, Integer count) {
        this.id = id;
        this.book_name = book_name;
        this.author_id = author_id;
        this.name = name;
        this.type_id = type_id;
        this.type = type;
        this.ISBN = ISBN;
        this.price = price;
        this.inventory = inventory;
        this.in_flg = in_flg;
        this.count = count;
    }
}
