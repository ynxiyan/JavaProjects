package com.springmvc_demo.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/14 14:16
 * @注释:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
