package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/30 8:56
 * @注释:人类(抽象)
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

    public void eat(String something) {
        System.out.println("我爱吃" + something);
    }

    /**
     * 重写toString（抽象）
     *
     * @return
     */
    public abstract String toString();
}
