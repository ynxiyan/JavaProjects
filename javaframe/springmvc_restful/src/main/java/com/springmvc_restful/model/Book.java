package com.springmvc_restful.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 10:28
 * @注释:
 */
@Data
public class Book {
    private String name;
    private double price;

    public Book() {
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
