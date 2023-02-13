package com.itheima.pattern.singleton.demo7.test;

import com.itheima.pattern.singleton.demo7.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 10:05
 * @注释:使用反射破坏单例模式
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //wri();
        red();
        red();
    }

    //从文件读取数据（对象）
    public static void red() throws Exception {
        //1.创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IntelliJ IDEA\\Projects\\Myinfo\\src\\com\\itheima\\pattern\\singleton\\demo7\\io\\a.txt"));
        //2.读取对象
        Singleton singleton = (Singleton) ois.readObject();
        System.out.println(singleton);
        //3.释放资源
        ois.close();
    }

    //向文件中写数据（对象）
    public static void wri() throws Exception {
//1.获取Singleton对象
        Singleton singleton = Singleton.getInstance();
        //2.创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IntelliJ IDEA\\Projects\\Myinfo\\src\\com\\itheima\\pattern\\singleton\\demo7\\io\\a.txt"));
        //3.写对象
        oos.writeObject(singleton);
        //4.释放资源
        oos.close();
    }
}
