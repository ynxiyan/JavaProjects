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
    private String stu_name;
    //年级
    private String grade_name;
    //年龄
    private Integer age;
    //地址
    private String address;
    //排序
    private Integer ordered;
    //状态
    private Integer statues;

    public Student() {
    }

    public Student(Integer id, String stu_name, String grade_name, Integer age, String address, Integer ordered, Integer statues) {
        this.id = id;
        this.stu_name = stu_name;
        this.grade_name = grade_name;
        this.age = age;
        this.address = address;
        this.ordered = ordered;
        this.statues = statues;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", grade_name='" + grade_name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", ordered=" + ordered +
                ", status=" + statues +
                '}';
    }
}
