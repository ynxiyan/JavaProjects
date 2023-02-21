package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/21 11:08
 * @注释:学生实体
 */
@Data
public class Student {
    //id
    private Integer id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;
    //状态
    private Integer state;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex, Integer state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.state = state;
    }
}
