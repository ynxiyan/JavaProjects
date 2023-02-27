package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:通过测试反射获取成员变量的值
 */
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取字节码文件对象
        Class<?> aClass = Class.forName("com.Student");
        //获取name属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        //创建一个有属性的对象
        Student student = new Student("张三", 18);
        System.out.println("student=" + student);
        //设置属性的值(参数1：要修改的对象  参数2：要修改的值)
        name.set(student, "李四");
        System.out.println("student=" + student);
        //获取属性的值(参数：要获取的对象)
        Object o = name.get(student);
        System.out.println(o);
    }
}
