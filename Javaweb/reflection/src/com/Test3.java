package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:通过测试反射创建对象
 */
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码文件对象
        Class<?> aClass = Class.forName("com.Student");
        //获取无参构造方法
        Constructor<?> constructor = aClass.getConstructor();
        //1.调用创建对象的方法
        Student student = (Student) constructor.newInstance();
        System.out.println("student" + student);
        //2.获取带参构造方法
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
        //创建对象需要传入构造方法所需的参数
        Student student1 = (Student) declaredConstructor.newInstance("张三", 18);
        //临时修改构造方法的访问权限（暴力反射）
        declaredConstructor.setAccessible(true);
        System.out.println("student1" + student1);
    }
}
