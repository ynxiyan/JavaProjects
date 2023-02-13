package com.qfedu.gather.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: XIYAN
 * @Date: 2023/1/10 18:16
 * @注释:Collection
 */
public class Demo1 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
     */
    public static void main(String[] args) {
        //创建集合
        Collection collection = new ArrayList<>();
        //添加元素
        collection.add("A");
        collection.add("B");
        collection.add("C");
        //返回元素个数
        System.out.println(collection.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(collection);
        //删除元素
        collection.remove("B");
        //删除所有
        //collection.clear();
        System.out.println("删除B元素后：");
        System.out.println(collection);
        //遍历元素
        System.out.println("1.使用增强for");
        for (Object object : collection) {
            System.out.print(object + "");
        }
        System.out.println("\n2.使用迭代器（专门用来遍历集合的一种方式）");
        Iterator iterator = collection.iterator();
        //判断有没有下一个元素，返回boolean
        while (iterator.hasNext()) {
            //获取下一个元素
            String str = (String) iterator.next();
            //删除当前元素（迭代过程中不能使用删除方法，可使用外部的集合对象进行删除）
            collection.remove(str);
            System.out.print(str + "");
        }
        //判断
        System.out.println("\n判断：");
        //是否存在C
        System.out.println(collection.contains("C"));
        //是否为空
        System.out.println(collection.isEmpty());
    }
}
