package com.wisezone.oop.tow;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 9:45
 * @注释:工人类
 */
public class Worker extends Person {
    private String workNumber;

    public Worker() {
    }

    public Worker(String name, int age, String workNumber) {
        super(name, age);
        this.workNumber = workNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public void worker() {
        System.out.println("我爱工作");
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
        return "我的名字是" + getName() + "，我的年龄是" + getAge() + "，我的工号是" + getWorkNumber();
    }
}
