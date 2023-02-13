package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/13 14:48
 * @注释:
 */
@Data
public class Dogs {
    private Integer id;
    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "Dogs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
