package com.springboot_ssm.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/20 16:36
 * @注释:
 */
@Data
public class Book {
    //    图书序号
    private Integer id;
    //    图书类型
    private String type;
    //    图书名称
    private String name;
    //    图书简介
    private String description;

    public Book() {
    }

    public Book(Integer id, String type, String name, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
