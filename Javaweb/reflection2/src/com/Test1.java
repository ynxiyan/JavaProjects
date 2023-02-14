package com;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 10:08
 * @注释:通过测试反射获取字节码对象Class
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class类中的静态方法
        Class<?> clazz = Class.forName("com.Student");
        //将Student加载到内存中在获取字节码对象
        //clazz Student 这个字节码对象
        System.out.println("clazz=" + clazz);
        //2.通过类的clazz属性
        Class<Student> studentClass = Student.class;
        //class字节码文件在硬盘上是唯一的，加载到内存中也是唯一的
        System.out.println(clazz == studentClass);
        //3.通过对象来获得字节码文件对象
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass == studentClass);
    }
}
