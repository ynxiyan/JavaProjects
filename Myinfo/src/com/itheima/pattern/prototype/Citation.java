package com.itheima.pattern.prototype;

import java.io.Serializable;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 9:30
 * @注释:
 */
//实现可克隆接口和序列化接口
public class Citation implements Cloneable, Serializable {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(student.getName());
    }
}
