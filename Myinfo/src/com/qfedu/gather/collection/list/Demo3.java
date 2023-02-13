package com.qfedu.gather.collection.list;

import java.util.*;

/**
 * @Author: XIYAN
 * @Date: 2023/1/11 15:36
 * @注释:vector实现list 数组结构实现 ，查询快 、增删慢 ；
 * JDK1.0 版本 ，运行效率慢 、线程安全 。
 */
public class Demo3 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
    5.获取元素位置
    6.返回子集合
     */
    public static void main(String[] args) {
        //创建vector集合
        Vector vector = new Vector();
        //添加元素
        vector.add("b");
        vector.add("c");
        vector.add("d");
        vector.add("e");
        vector.add(0, "a");
        //返回元素个数
        System.out.println(vector.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(vector);
        //删除元素
        vector.remove("c");
        vector.remove(0);
        //删除所有
        //list.clear();
        System.out.println("删除元素后：");
        System.out.println(vector);
        //遍历元素
        System.out.println("1.使用for");
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + "");
        }
        System.out.println("\n2.使用增强for");
        for (Object object : vector) {
            System.out.print(object + "");
        }
        System.out.println("\n3.使用枚举器");
        Enumeration enumeration = vector.elements();
        //判断有没有下一个元素，返回boolean
        while (enumeration.hasMoreElements()) {
            //获取下一个元素
            System.out.print(enumeration.nextElement() + "");
        }
        System.out.println("\n4.使用迭代器");
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        ListIterator listIterator = vector.listIterator();
        System.out.println("\n正向");
        while (listIterator.hasNext()) {
            System.out.print("[" + listIterator.nextIndex() + "]" + (String) listIterator.next() + "");
        }
        System.out.println("\n逆向");
        while (listIterator.hasPrevious()) {
            System.out.print("[" + listIterator.previousIndex() + "]" + listIterator.previous() + "");
        }
        System.out.println();
        //判断
        System.out.println(vector.contains("d"));
        System.out.println(vector.isEmpty());
        System.out.println(vector.indexOf("e"));
        List subList = vector.subList(1, 3);
        System.out.println(subList);
    }
}
