package com.kuangstudy.oop.people;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:23
 * @注释:男人
 */
public class Man extends People {
    //man有个属性是老婆,有一个方法是lol
    private String wife;

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void lol() {
        System.out.println("lol");
    }
}
