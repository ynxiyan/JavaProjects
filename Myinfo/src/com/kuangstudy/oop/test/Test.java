package com.kuangstudy.oop.test;

/**
 * @Author: XIYAN
 * @Date: 2023/1/9 13:01
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        //向上转型
        Demo demo = new Stu();
        //demo原来的类型是Demo,但因为向上转型后实际类型是Stu,所以调用的是子类Stu重写后的方法
        System.out.println("向上转型后：");
        demo.eat();
        //向下转型
        Stu stu = (Stu) demo;
        //stu原来的类型是Stu,但因为向下转型后实际类型是Demo,又因为Demo demo = new Stu(),所以能调用子类Stu中的方法
        System.out.println("向下转型后：");
        stu.eat();
        stu.study();
    }
}
