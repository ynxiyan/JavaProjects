# [Java多态](https://www.cnblogs.com/ynxiyan/p/17037451.html)

### 1.多态概述

多态是继封装、继承之后，面向对象的第三大特性。

- 多态现实意义理解：

  现实事物经常会体现出多种形态，如学生，学生是人的一种，则一个具体的同学张三既是学生也是人，即出现两种形态。

  Java作为面向对象的语言，同样可以描述一个事物的多种形态。如Student类继承了Person类，一个Student的对象便既是Student，又是Person。

```markdown
 1.多态体现为父类引用变量可以指向子类对象。
 
 2.前提条件：必须有子父类关系。
注意：在使用多态后的父类引用变量调用方法时，会调用子类重写后的方法。
 
 3.多态的定义与使用格式
               定义格式：父类类型 变量名 = new 子类类型();

 4.理解:
           多态是同一个行为具有多个不同表现形式或形态的能力。
           多态就是同一个接口，使用不同的实例而执行不同操作。
 
```

### 2.多态中成员的特点

多态成员变量：编译运行看左边
Fu f=new Zi();

```java
     System.out.println(f.num);//f是Fu中的值，只能取到父中的值
 
 2.多态成员方法：编译看左边，运行看右边
    Fu f1=new Zi();
    System.out.println(f1.show());//f1的门面类型是Fu,但实际类型是Zi,所以调用的是重写后的方法。
```

### 3.instanceof关键字

 作用：用来判断某个对象是否属于某种数据类型。

```java
注意： 返回类型为布尔类型
使用案例：
    Fu f1=new Zi();
    Fu f2=new Son();
    if(f1 instanceof Zi){
        System.out.println("f1是Zi的类型");
    }
    else{
        System.out.println("f1是Son的类型");
    }
```

### 4.多态的转型

 多态的转型分为向上转型和向下转型两种

- 向上转型：多态本身就是向上转型过的过程
  使用格式：父类类型 变量名 = new 子类类型();

  ```markdown
      适用场景：当不需要面对子类类型时，通过提高扩展性，或者使用父类的功能就能完成相应的操作。
  
  ```

- 向下转型：一个已经向上转型的子类对象可以使用强制类型转换的格式，将父类引用类型转为子类引用各类型
  使用格式：子类类型 变量名 =（子类类型） 父类类型的变量；

  ```markdown
      适用场景：当要使用子类特有功能时。
  
  ```

### 5.多态案例：

例1：（理解多态，可以重点看这个案例）

```java
package com.kuangstudy.oop.test;
 
public class Test {
    public static void main(String[] args) {
        //向上转型
        Demo demo = new Stu();
        //demo原来的类型是Demo,但因为向上转型后实际类型是Stu,所以调用的是子类Stu重写后的方法
        System.out.println("向上转型后：");
        demo.eat();
        //向下转型
        Stu stu = (Stu) demo;
        //stu原来的类型是Stu,但因为向下转型后实际类型是Demo,又因为Demo demo = new Stu(),所以能调用子类Stu中的方法
        System.out.println("向下转型后：");
        stu.eat();
        stu.study();
    }
}
 
//父类
public class Demo {
    public void eat() {
        System.out.println("吃饭");
    }
}
 
//子类
public class Stu extends Demo{
    @Override
    public void eat() {
        System.out.println("吃面");
    }
 
    public void study() {
        System.out.println("好好学习");
    }
}
 
运行结果：
        向上转型后：
        吃面
        向下转型后：
        吃面
        好好学习
```

原文链接：https://blog.csdn.net/qq_41679818/article/details/90523285