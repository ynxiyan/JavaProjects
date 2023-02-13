package com.wisezone.oop.four.test;

import com.wisezone.oop.four.Student;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 9:38
 * @注释:
 */
public class TestStu {
    public static void main(String[] args) {
        //判断是同一个对象
        Student studentOne = new Student("007", "赵四", 20);
        Student studentTwo = new Student("007", "赵四", 20);
        //不等于
        System.out.println(studentOne.equals(studentTwo));
        System.out.println(studentOne);
        System.out.println(studentTwo);
    }
}
