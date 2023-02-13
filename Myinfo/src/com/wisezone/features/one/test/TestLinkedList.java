package com.wisezone.features.one.test;

import com.wisezone.features.one.Dog;

import java.util.LinkedList;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 10:18
 * @注释:
 */
public class TestLinkedList {
    public static void main(String[] args) {
        Dog dog1 = new Dog("欧欧", "雪娜瑞");
        Dog dog2 = new Dog("亚亚", "拉布拉多");
        Dog dog3 = new Dog("菲菲", "拉布拉多");
        Dog dog4 = new Dog("美美", "雪娜瑞");
        LinkedList list = new LinkedList<>();
        //添加第一条狗狗
        list.addFirst(dog3);
        list.add(dog1);
        list.add(dog2);
        //添加最后一条狗狗
        list.addLast(dog4);
        //输出第一条狗狗
        System.out.println("第一条狗狗的名字：" + ((Dog) list.getFirst()).getName());
        //输出最后一条狗狗
        System.out.println("最后一条狗狗的名字：" + ((Dog) list.getLast()).getName());
        //删除第一条狗狗
        list.remove(list.getFirst());
        //删除最后一条狗狗
        list.remove(list.getLast());
        System.out.println("\n删除部分狗狗后还有" + list.size() + "条狗狗");
        System.out.println("分别是：");
        list.forEach(System.out::println);
    }
}
