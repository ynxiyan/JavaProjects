package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 8:57
 * @注释:老师类
 */
public class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void teach(String subject) {
        System.out.println("我教授的是" + subject);
    }
    @Override
    public String toString() {
        return "我的名字是" + getName() + "，我的年龄是" + getAge()+"，我教授的是"+getSubject();
    }
}
