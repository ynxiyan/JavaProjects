package com.itheima.pattern.prototype;

import java.io.Serializable;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 11:21
 * @注释:
 */
//实现序列化接口
public class Student implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
