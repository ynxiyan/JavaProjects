package com.qfedu.gather.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: XIYAN
 * @Date: 2023/1/11 14:43
 * @注释:arraylist实现list 数组结构实现 ， 查询快 、 增删慢 ；
 * JDK1. 2 版本 ， 运行效率快 、 线程不安全 。
 * - 源码分析：
 * 默认容量：DEFAULT_CAPACITY = 10 ；
 * - 注意：如果没有向集合中添加任何元素，则容量为0
 * 存放元素的数组：elementData
 * 实际元素个数：size
 */
public class Demo2 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
    5.获取元素位置
    6.返回子集合
     */
    public static void main(String[] args) {
        //创建arrayList集合
        ArrayList arrayList = new ArrayList<>();
        //添加元素
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        //通过下标添加元素
        arrayList.add(0, "a");
        //返回元素个数
        System.out.println(arrayList.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(arrayList);
        //删除元素
        arrayList.remove("c");
        //通过下标删除元素(保存int型数据时默认调用remove(下标),需将要删除的数字转成(Object)或new Integer())
        arrayList.remove(0);
        //删除所有
        //list.clear();
        System.out.println("删除元素后：");
        System.out.println(arrayList);
        //遍历元素
        System.out.println("1.使用for");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "");
        }
        System.out.println("\n2.使用增强for");
        for (Object object : arrayList) {
            System.out.print(object + "");
        }
        System.out.println("\n3.使用迭代器");
        //collection迭代器
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        //list迭代器（正向、逆向）
        ListIterator listIterator = arrayList.listIterator();
        System.out.println("\n正向");
        while (listIterator.hasNext()) {
            //获取下一个元素的下标和值
            System.out.print("[" + listIterator.nextIndex() + "]" + (String) listIterator.next() + "");
        }
        System.out.println("\n逆向");
        //判断有没有上一个元素，返回boolean
        while (listIterator.hasPrevious()) {
            //获取上一个元素的下标和值
            System.out.print("[" + listIterator.previousIndex() + "]" + listIterator.previous() + "");
        }
        System.out.println();
        //判断
        System.out.println(arrayList.contains("d"));
        System.out.println(arrayList.isEmpty());
        //获取元素位置
        System.out.println(arrayList.indexOf("e"));
        //返回子集合
        List subList = arrayList.subList(1, 3); //开始位置，结束位置（使用下标）
        System.out.println(subList);
    }
}
