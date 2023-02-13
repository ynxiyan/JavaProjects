package com.wisezone.oop.one.test;

/**
 * @Author: XIYAN
 * @Date: 2022/12/17 20:40
 * @注释:教师类
 */
public class Teacher {
    String name;
    String specialized;
    String course;
    int seniority;

    public void showteacher() {
        System.out.println(name + "\n专业方向：" + specialized + "\n教授课程：" + course + "\n教龄：" + seniority);
    }
}
