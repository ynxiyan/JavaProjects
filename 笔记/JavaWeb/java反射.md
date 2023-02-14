### 一、反射的概述

---

Java的反射（reflection）机制是指在程序的运行状态中，可以构造任意一个类的对象，可以了解任意一个对象所属的类，可以了解任意一个类的成员变量和方法，可以调用任意一个对象的属性和方法。这种动态获取程序信息以及动态调用对象的功能称为Java语言的反射机制。反射被视为动态语言的关键。

```markdown
- 在 java 程序运行中 ， 对于任意一个类， 都能够通过反射知道这个类的所有属性和方法
- 对于这任意的一个类的对象 ， 能够访问任意属性和方法
- 这种动态获取信息以及动态调用对象成员的功能我们称为 Java 语言的反射机制 。
（ 运行起来后的xx.class字节码文件 ， JVM 会对应的生成一个 java.lang.Class 类的对象 ， 该对象是获取成员的关键）
```

反射机制所需的类主要有java.lang包中的Class类和java.lang.reflect包中的Constructor类（构造方法）、Field类（属性）、Method类（普通方法）和Parameter类（参数）。

### 二、反射机制原理示意图

![image-20230214105924189](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230214105924189.png)

### 二、学习反射学的是什么？

---

反射是通过 class 字节码文件生成 Class 的对象然后获取里面的内容

```markdown
- 如何从 class 字节码文件中获取对象 (Class 对象 ）
- 如何获取构造方法 （ 创建对象 ）
- 如何获取属性 （ 赋值取值 ）
- 如何获取其他方法 （ 调用 ）
```

#### 1.获取字节码对象

##### 1-1.Class类中的静态方法

```java
Class.forName("com.Student");
```

##### 1-2.通过类的clazz属性

```java
Student.class;
```

##### 1-3.通过对象来获得字节码文件对象

```java
Student student = new Student();
Class<? extends Student> aClass = student.getClass();
```

#### 2.理解

java 文件 ： 就是我们建立书写的 java 代码文件
字节码文件 ： 通过 java 文件翻译之后 class 文件 （ 存在硬盘 ， 真实可见 ）
字节码文件对象 ：当class文件加载内存之后，虚拟机自动创建出来的对象这个对象会包含构造器、属性、如何获取其他方法

我们反射获得的就是字节码对象 ， 在内存中和硬盘中都是唯一的



# 未完待续。。。

所有的笔记来源于：[韩顺平 (bilibili.com)](https://space.bilibili.com/651245581)
