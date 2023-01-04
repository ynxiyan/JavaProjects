package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 8:57
 * @注释:学生类
 */
public class Student extends Person {
    private String class_;

    public Student() {
    }

    public Student(String name, int age, String class_) {
        super(name, age);
        this.class_ = class_;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public void study(String subject) {
        System.out.println("我热爱学习" + subject);
    }

    @Override
    public String toString() {
        return "我的名字是" + getName() + "，我的年龄是" + getAge() + "，我的班级是" + getClass_();
    }
}
