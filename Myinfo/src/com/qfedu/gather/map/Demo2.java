package com.qfedu.gather.map;

import com.qfedu.gather.collection.list.Student;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: XIYAN
 * @Date: 2023/1/16 16:21
 * @注释:TreeMap 存储结构：红黑树
 * 要求元素必须实现Comparable接口
 * compareTo方法返回0则认为是重复元素
 */
public class Demo2 {
    /*
    1.添加元素
    2.删除元素
    3.遍历元素
    4.判断
     */
    public static void main(String[] args) {
        //创建TreeMap<Student,String>集合
//        TreeMap<Student,String> treeMap = new TreeMap<>();
        //创建TreeMap<Student,String>集合并指定比较规则（无需实现Comparable接口）
        TreeMap<Student, String> treeMap = new TreeMap<>(new Comparator<Student>() {
            /**
             * 先按年龄比较，然后再按姓名比较
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Student o1, Student o2) {
                int num1 = o1.getAge() - o2.getAge();
                int num2 = o1.getName().compareTo(o2.getName());
                return num1 == 0 ? num2 : num1;
            }
        });
        //实例化Student并赋值
        Student student1 = new Student("张三", 18);
        Student student2 = new Student("赵四", 20);
        Student student3 = new Student("李华", 16);
        //添加元素
        treeMap.put(student1, "a");
        treeMap.put(student2, "b");
        treeMap.put(student3, "c");
        //返回元素个数
        System.out.println(treeMap.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(treeMap);
        //删除元素
        treeMap.remove(student2);
        //删除所有
        //treeMap.clear();
        System.out.println("删除元素后：");
        System.out.println(treeMap);
        //遍历元素
        System.out.println("1.使用keySet");
        for (Student key : treeMap.keySet()) {
            System.out.println(key + "-" + treeMap.get(key));
        }
        System.out.println("\n2.使用entrySet");
        for (Map.Entry<Student, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();
        //判断
        System.out.println(treeMap.containsKey(student2));
        System.out.println(treeMap.containsValue("a"));
        System.out.println(treeMap.isEmpty());
    }
}
