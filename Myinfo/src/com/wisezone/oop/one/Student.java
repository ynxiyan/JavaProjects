package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/17 20:40
 * @注释:学生类
 */
public class Student {
    public String name;
    public int age;
    public String classNo;
    public String hobby;

    public void showstudent() {
        System.out.println(name + "\n年龄：" + age + "\n就读于：" + classNo + "\n爱好：" + hobby);
    }
}
