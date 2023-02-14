package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 16:17
 * @注释:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //创建字节码文件对象
        Class<?> aClass = Class.forName("com.test.Person");
        //获取类对象
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //通过对象获取字节码文件对象
        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        System.out.println(aClass1);
        //获取构造方法
        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor1 : constructors) {
            System.out.println(constructor1);
        }
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        System.out.println(declaredConstructor);
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor1 : declaredConstructors) {
            System.out.println(declaredConstructor1);
        }
        //创建对象
        Object person1 = aClass.newInstance();
        System.out.println(person1);
        //获取name属性
        Field id = aClass.getField("id");
        id.setAccessible(true);
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //设置name属性的值
        person.setName("zhh");
        person.setAge(18);
        id.set(person, 1);
        System.out.println(person);
        //获取name属性的值
        Object o = id.get(person);
        System.out.println(o);
        //获取方法
        Method test1 = aClass.getMethod("test1");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Method test2 = aClass.getDeclaredMethod("test2", int.class);
        test2.setAccessible(true);
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethods);
        }
        //调用方法
        test1.invoke(person);
        test2.invoke(person, 2);
    }

}
