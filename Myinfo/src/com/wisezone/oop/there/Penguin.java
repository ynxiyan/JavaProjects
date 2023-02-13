package com.wisezone.oop.there;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 9:04
 * @注释:
 */
public class Penguin {
    String name;
    int love;
    int health;
    String sex;

    /**
     * 构造方法（无参）
     */
    public Penguin() {
        //调用当前对象下的构造方法（必须在第一行）
        this("欧欧", 100, 100, "Q仔");
//        name = "欧欧";
//        love = 100;
//        health = 100;
//        sex = "Q仔";
        //还是调用无参构造方法
//        new Penguin("欧欧",100,100,"Q仔");
    }

    /**
     * 构造方法（带参）<方法重载>
     *
     * @param name
     * @param love
     * @param health
     * @param sex
     */
    public Penguin(String name, int love, int health, String sex) {
        this.name = name;
        this.love = love;
        this.health = health;
        this.sex = sex;
    }

    public void show() {
        System.out.println("我的昵称叫：" + name + "\n健康值是：" + health + "\n和主人的亲密度是：" + love + "\n性别是：" + sex);
    }
}
