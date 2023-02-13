package com.wisezone.oop.seven.animal;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 17:12
 * @注释:动物园
 */
public abstract class Animal {
    private String name;
    private int legNum;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegNum() {
        return legNum;
    }

    public void setLegNum(int legNum) {
        this.legNum = legNum;
    }

    /**
     * 叫
     */
    public abstract String show();

    @Override
    public String toString() {
        return name;
    }
}
