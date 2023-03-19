package com.ssm_maven.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 15:14
 * @注释:图书实体
 */
//自动装配get、set方法
@Data
public class Book {
    //图书序号
    private Integer id;
    //图书类型
    private String type;
    //图书名称
    private String name;
    //图书简介
    private String description;

    public Book() {
    }

    public Book(Integer id, String type, String name, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
