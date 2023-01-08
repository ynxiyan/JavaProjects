package com.kuangstudy.oop.books;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 16:47
 * @注释:
 */
public class TestBook {
    /*
    实现图书信息设置(封装)
    任务：
    属性：书名、作者、出版社、价格
    方法：信息介绍
    要求：
    设计构造函数实现对属性赋值
    设置私有属性，get/set方法实现对属性的访问
    限定图书价格必须大于10，如果无效需进行提示，并强制赋值为10
    限定作者、书名均为只读属性
    信息介绍方法描述图书所有信息
     */
    public static void main(String[] args) {
        System.out.println(new Book("", "", "", 1.2));
    }
}
