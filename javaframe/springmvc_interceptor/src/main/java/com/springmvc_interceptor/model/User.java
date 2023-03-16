package com.springmvc_interceptor.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/15 10:28
 * @注释:
 */
@Data
public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
