package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 15:35
 * @注释:学生实体
 */
@Data
public class Student {
    //id
    private Integer id;
    //姓名
    private String name;
    //年级
    private String grade;
    //年龄
    private Integer age;
    //地址
    private String address;
    //排序
    private Integer ordered;
    //状态
    private Integer status;

    public Student() {
    }

    public Student(Integer id, String name, String grade, Integer age, String address, Integer ordered, Integer status) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.address = address;
        this.ordered = ordered;
        this.status = status;
    }
}
