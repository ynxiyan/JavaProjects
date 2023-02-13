package com.qfedu.gather.collection.set;

import com.qfedu.gather.collection.list.Student;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: XIYAN
 * @Date: 2023/1/16 14:23
 * @注释:TreeSet 存储结构：红黑树
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
        //创建TreeSet<Student>集合
//        TreeSet<Student> treeSet = new TreeSet<>();
        /**
         * Comparator:实现定制比较（比较器）
         * Comparable:可比较的
         */
        //创建TreeSet<Student>集合并指定比较规则（无需实现Comparable接口）
        TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
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
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        //返回元素个数
        System.out.println(treeSet.size());
        //返回元素集合
        System.out.println("返回元素集合：");
        System.out.println(treeSet);
        //删除元素
        treeSet.remove(student2);
        //删除所有
        //treeSet.clear();
        System.out.println("删除元素后：");
        System.out.println(treeSet);
        //遍历元素
        System.out.println("1.使用增强for");
        for (Student s : treeSet) {
            System.out.print(s + "");
        }
        System.out.println("\n2.使用迭代器");
        //迭代器
        Iterator<Student> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "");
        }
        System.out.println();
        //判断
        System.out.println(treeSet.contains(student2));
        System.out.println(treeSet.isEmpty());
    }
}
