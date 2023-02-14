package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:通过测试反射获取成员变量
 */
public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取字节码文件对象
        Class<?> aClass = Class.forName("com.Student");
        //1.获取所有公共的成员变量对象
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("field=" + field);
        }
        //2.获取所有的成员变量对象
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField=" + declaredField);
        }
        //3.获取单个公共成员变量对象
        Field name = aClass.getField("name");
        System.out.println("name=" + name);
        //4.获取单个成员变量对象
        Field name1 = aClass.getDeclaredField("name");
        System.out.println("name=" + name1);
    }
}
