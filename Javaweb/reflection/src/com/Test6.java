package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:通过测试反射获取方法
 */
public class Test6 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取字节码文件对象
        Class<?> aClass = Class.forName("com.Student");
        Student student = new Student();
        //1.获取当前类与父类的所有公共方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //2.获取当前类与父类的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        //3.获取公共的单个方法(参数1：方法名   参数2：方法参数)
        Method sleep = aClass.getMethod("sleep");
        Method eat = aClass.getMethod("eat", String.class);
        //4.获取单个方法(参数1：方法名   参数2：方法参数)
        Method getName = aClass.getDeclaredMethod("getName");
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        //5.调用方法(参数1：调用的对象  参数2：方法的参数)
        sleep.invoke(student);
        String invoke = (String) eat.invoke(student, "a");
        System.out.println(invoke);
    }
}
