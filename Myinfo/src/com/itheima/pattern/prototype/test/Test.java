package com.itheima.pattern.prototype.test;

import com.itheima.pattern.prototype.Citation;
import com.itheima.pattern.prototype.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 9:36
 * @注释:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //创建一个原型对象
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        citation.setStudent(student);
        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IntelliJ IDEA\\Projects\\Myinfo\\src\\com\\itheima\\pattern\\prototype\\io\\a.txt"));
        //写对象
        oos.writeObject(citation);
        //释放资源
        oos.close();
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IntelliJ IDEA\\Projects\\Myinfo\\src\\com\\itheima\\pattern\\prototype\\io\\a.txt"));
        //读取对象
        Citation citation1 = (Citation) ois.readObject();
        //释放资源
        ois.close();
        Student student1 = citation1.getStudent();
        student1.setName("李四");
        citation.show();
        citation1.show();
    }
}
