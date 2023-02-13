package com.wisezone.oop.tow;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 9:44
 * @注释:学生类
 */
public class Student extends Person {
    private String studentNumber;

    public Student() {
    }

    public Student(String name, int age, String studentNumber) {
        super(name, age);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void learn() {
        System.out.println("我爱学习");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉");
    }

    @Override
    public String toString() {
        return "我的名字是" + getName() + "，我的年龄是" + getAge() + "，我的学号是" + getStudentNumber();
    }
}
