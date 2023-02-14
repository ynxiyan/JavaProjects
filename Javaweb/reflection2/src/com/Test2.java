package com;

import java.lang.reflect.Constructor;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:
 */
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //1.获取字节码文件对象
        Class<?> aClass = Class.forName("com.Student");
        //2.获取构造方法(公共、所有)的对象
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor" + constructor);
        }
        //3.获取构造方法(公共、私有、所有)的对象
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor" + declaredConstructor);
        }
        //4.获取无参或带参(参数需要类的字节码文件)构造方法
        Constructor<?> constructor = aClass.getConstructor();
        Constructor<?> constructor1 = aClass.getConstructor(String.class, Integer.class);
        //也可以获取指定的构造方法，但是与上面不同的是还可以获取私有构造方法
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
    }
}
