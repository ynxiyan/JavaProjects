package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/27 15:52
 * @注释:学生
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
