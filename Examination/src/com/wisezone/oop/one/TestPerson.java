package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 8:58
 * @注释:
 */
public class TestPerson {
    public static void main(String[] args) {
        Student student = new Student("张三",18,"2202");
        Teacher teacher=new Teacher("丽华",32,"Java");
        student.study("MySQL");
        student.eat("水果");
        System.out.println(student);
        System.out.println();
        teacher.teach("Java");
        teacher.eat("蔬菜");
        System.out.println(teacher);
    }
}
