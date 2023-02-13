package com.wisezone.oop.tow;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 9:51
 * @注释:
 */
public class TestPerson {
    public static void main(String[] args) {
        Student student=new Student("李明",19,"20221203");
        Worker worker=new Worker("赵四",34,"11002836");
        student.eat();
        student.sleep();
        student.learn();
        System.out.println(student);
        System.out.println();
        worker.eat();
        worker.sleep();
        worker.worker();
        System.out.println(worker);
    }
}
