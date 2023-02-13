package com.qfedu.gather.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/1/13 18:01
 * @注释:在一个列表中存储以下元素：apple,grape,banana,pear 返回集合中的最大的和最小的元素
 */
public class Scort {
    public static void main(String[] args) {
        //创建String集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("apple");
        list.add("grape");
        list.add("banana");
        list.add("pear");
        System.out.println("排序前：");
        for (String s : list) {
            System.out.print(s + "\t");
        }
        //排序集合
        Collections.sort(list);
        System.out.println("\n排序后：");
        for (String s : list) {
            System.out.print(s + "\t");
        }
    }
}
