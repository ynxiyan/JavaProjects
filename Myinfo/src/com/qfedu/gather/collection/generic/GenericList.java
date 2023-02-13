package com.qfedu.gather.collection.generic;

import com.qfedu.gather.collection.list.Student;

import java.util.ArrayList;

/**
 * @Author: XIYAN
 * @Date: 2023/1/14 15:40
 * @注释:泛型集合 特点 ：
 * 1.编译时即可检查，而非运行时抛出异常。
 * 2.访问时，不必类型转换。
 * 3.不同泛型之间引用不能相互赋值，泛型不存在多态。
 */
public class GenericList {
    public static void main(String[] args) {
        //泛型集合
        ArrayList<Student> arrayList = new ArrayList<>();
        //确认类型后编译时会检查，而非运行时报异常
        //arrayList.add("11111");
        arrayList.add(new Student("张三", 18));
        for (Student student : arrayList) {
            System.out.println(student);
        }
    }
}
