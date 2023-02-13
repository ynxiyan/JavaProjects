package com.wisezone.oop.four;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 9:22
 * @注释:
 */
public class Demo {
    private int id;
    private String name;
    private int age;

    public Demo() {
    }

    public Demo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /**
     * 重写toString()方法
     *
     * @return
     */
    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
