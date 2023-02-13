package com.wisezone.oop.tow;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 9:40
 * @注释:人类（抽象）
 */
public abstract class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat();

    public abstract void sleep();

    public abstract String toString();
}
