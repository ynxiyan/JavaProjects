package com.qfedu.gather.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XIYAN
 * @Date: 2023/1/16 15:33
 * @注释:HashMap 特点：
 * 1.存储键值对
 * 2.键不能重复，值可以重复
 * 3.无序
 */
public class Demo1 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
     */
    public static void main(String[] args) {
        //创建HashMap<Integer, String>集合
        HashMap<Integer, String> hashMap = new HashMap();
        //添加元素(键，值)
        hashMap.put(1, "b");
        hashMap.put(2, "c");
        hashMap.put(3, "d");
        hashMap.put(4, "e");
        //返回元素个数
        System.out.println(hashMap.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(hashMap);
        //删除元素(key)
        hashMap.remove(2);
        //删除所有
        //hashMap.clear();
        System.out.println("删除元素后：");
        System.out.println(hashMap);
        //遍历元素
        System.out.println("1.使用keySet");
        for (Integer key : hashMap.keySet()) {
            //通过循环key得到对应的value
            System.out.println(key + "-" + hashMap.get(key));
        }
        System.out.println("\n2.使用entrySet");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();
        //判断
        System.out.println(hashMap.containsKey(2)); //通过键
        System.out.println(hashMap.containsValue("b")); //通过值
        System.out.println(hashMap.isEmpty());
    }
}
