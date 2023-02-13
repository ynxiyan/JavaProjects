package com.qfedu.gather.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: XIYAN
 * @Date: 2023/1/14 16:20
 * @注释:HashSet 特点：无序、无下标、元素不可重复
 * 存储结构：哈希表（数组+链表+红黑树）
 * 存储过程：
 * 1.根据hashcode计算保存位置，如果位置为空则直接保存，否则执行下一步
 * 2.执行equals方法，如果equals返回true则为重复元素，否则形成链表
 */
public class Demo1 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
     */
    public static void main(String[] args) {
        //创建Set<String>集合
        HashSet<String> hashSet = new HashSet();
        //添加元素
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("e");
        //返回元素个数
        System.out.println(hashSet.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(hashSet);
        //删除元素
        hashSet.remove("c");
        //删除所有
        //hashSet.clear();
        System.out.println("删除元素后：");
        System.out.println(hashSet);
        //遍历元素
        System.out.println("1.使用增强for");
        for (String s : hashSet) {
            System.out.print(s + "");
        }
        System.out.println("\n2.使用迭代器");
        //迭代器
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        System.out.println();
        //判断
        System.out.println(hashSet.contains("d"));
        System.out.println(hashSet.isEmpty());
    }
}
