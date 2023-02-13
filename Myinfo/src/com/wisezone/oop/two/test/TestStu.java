package com.wisezone.oop.two.test;

import com.wisezone.oop.two.Student;
import com.wisezone.oop.two.StudentBiz;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:37
 * @注释:
 */
public class TestStu {
    public static void main(String[] args) {
        Student studentOne = new Student();
        Student studentTwo = new Student();

        studentOne.no = "10";
        studentOne.name = "王紫";
        studentOne.age = 18;
        studentOne.score = 99;
        studentTwo.no = "11";
        studentTwo.name = "郝田";
        studentTwo.age = 19;
        studentTwo.score = 60;

        StudentBiz studentBiz = new StudentBiz();
        studentBiz.addStu(studentOne);
        studentBiz.addStu(studentTwo);
        System.out.println("本班学生列表：");
        studentBiz.showStu();
    }
}
