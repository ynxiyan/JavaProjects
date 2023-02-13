package com.qfedu.gather.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: XIYAN
 * @Date: 2023/1/10 17:24
 * @注释:学生信息
 */
public class StudentCollection {

    public static void main(String[] args) {
        //创建集合
        Collection collection = new ArrayList<>();
        //实例化Student
        Student student1 = new Student("张三", 18);
        Student student2 = new Student("赵四", 20);
        Student student3 = new Student("李华", 16);
        //添加学生信息
        collection.add(student1);
        collection.add(student2);
        collection.add(student3);
        //删除学生信息
        collection.remove(student2);
        //遍历学生信息
        Iterator iterator = collection.iterator(); //迭代器
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
        //判断学生是否存在
        System.out.println(collection.contains(student2));
    }
}
