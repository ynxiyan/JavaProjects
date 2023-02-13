package com.wisezone.features.one.test;

import com.wisezone.features.one.Dog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 9:17
 * @注释:
 */
public class TestArrayList {
    public static void main(String[] args) {
        //创建对象
        Dog dog1 = new Dog("欧欧", "雪娜瑞");
        Dog dog2 = new Dog("亚亚", "拉布拉多");
        Dog dog3 = new Dog("菲菲", "拉布拉多");
        Dog dog4 = new Dog("美美", "雪娜瑞");
        //创建集合
        List list = new ArrayList<>();
        //添加
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        list.add(dog4);
        //计算list总数
        System.out.println("共计有" + list.size() + "条狗狗");
        System.out.println("分别是：");
        //迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n删除之前共计有" + list.size() + "条狗狗");
        //删除list指定下标
        list.remove(1);
        //删除list指定名称
        list.remove(dog3);
        System.out.println("\n删除之后共计有" + list.size() + "条狗狗");
        //更新
        Dog dog5 = new Dog("欧欧", "二哈");
        list.remove(dog1);
        list.add(0, dog5);
        System.out.println("分别是：");
        //lambda表达式
        list.forEach(System.out::println);
        //判断list是否存在对象
        if (list.contains(dog4)) {
            System.out.println("\n集合中包含美美的信息");
        } else {
            System.out.println("\n集合中不包含美美的信息");
        }
    }
}
