package com.qfedu.gather.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: XIYAN
 * @Date: 2023/1/11 16:52
 * @注释:linkedList实现list 链表结构实现 ，增删快 ，查询慢 。
 */
public class Demo4 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
    5.获取元素位置
    6.返回子集合
     */
    public static void main(String[] args) {
        //创建linkedList集合
        LinkedList linkedList = new LinkedList();
        //添加元素
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add(0, "a");
        //返回元素个数
        System.out.println(linkedList.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(linkedList);
        //删除元素
        linkedList.remove("c");
        linkedList.remove(0);
        //删除所有
        //list.clear();
        System.out.println("删除元素后：");
        System.out.println(linkedList);
        //遍历元素
        System.out.println("1.使用for");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + "");
        }
        System.out.println("\n2.使用增强for");
        for (Object object : linkedList) {
            System.out.print(object + "");
        }
        System.out.println("\n4.使用迭代器");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        ListIterator listIterator = linkedList.listIterator();
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
        System.out.println(linkedList.contains("d"));
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.indexOf("e"));
        List subList = linkedList.subList(1, 3);
        System.out.println(subList);
    }
}
