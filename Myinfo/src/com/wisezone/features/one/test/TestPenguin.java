package com.wisezone.features.one.test;

import com.wisezone.features.one.Penguin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 10:05
 * @注释:
 */
public class TestPenguin {
    public static void main(String[] args) {
        Penguin penguin1 = new Penguin("欧欧", "Q仔");
        Penguin penguin2 = new Penguin("亚亚", "Q妹");
        Penguin penguin3 = new Penguin("菲菲", "Q妹");
        Penguin penguin4 = new Penguin("美美", "Q妹");
        List list = new ArrayList<>();
        list.add(penguin1);
        list.add(penguin2);
        list.add(penguin3);
        list.add(penguin4);
        System.out.println("共计有" + list.size() + "只企鹅");
        System.out.println("分别是：");
        list.forEach(System.out::println);
        list.remove(penguin2);
        list.remove(penguin4);
        System.out.println("\n删除之后还有" + list.size() + "只企鹅");
        System.out.println("分别是：");
        list.forEach(System.out::println);
        if (list.contains(penguin4)) {
            System.out.println("\n集合中包含美美的信息");
        } else {
            System.out.println("\n集合中不包含美美的信息");
        }
    }
}
