package com.wisezone.oop.one.test;

import com.wisezone.oop.one.Student;

/**
 * @Author: XIYAN
 * @Date: 2022/12/17 20:30
 * @注释:测试类
 */
public class TestST {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.name = "张浩";
        student.age = 10;
        student.classNo = "51班";
        student.hobby = "篮球";
        teacher.name = "王老师";
        teacher.specialized = "计算机";
        teacher.course = "使用Java语言理解程序逻辑";
        teacher.seniority = 5;
        student.showstudent();
        System.out.println();
        teacher.showteacher();
    }
}
