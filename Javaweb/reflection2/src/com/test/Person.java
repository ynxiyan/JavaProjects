package com.test;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 16:14
 * @注释:
 */
public class Person {
    public int id;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void test1() {
        System.out.println("test1");
    }

    public int test2(int num) {
        System.out.println(num);
        return num;
    }
}
