# [java反射](https://www.cnblogs.com/ynxiyan/p/17119092.html)

### 一、反射的概述

---

Java反射机制是指在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

通过反射机制，可以在不了解类的结构的情况下，调用对象的方法，并进行对象的属性访问，这加强了程序的灵活性，使得java语言可以在多态的环境中发挥更大的作用。反射机制也使得java语言可以在运行时期动态的加载类，从而实现动态加载。

简述：

```markdown
- 在 java 程序运行中 ， 对于任意一个类， 都能够通过反射知道这个类的所有属性和方法
- 对于这任意的一个类的对象 ， 能够访问任意属性和方法
- 这种动态获取信息以及动态调用对象成员的功能我们称为 Java 语言的反射机制 。
	（ 运行起来后的xx.class字节码文件 ， JVM 会对应的生成一个 java.lang.Class 类的对象 ， 该对象是获取成员的关键）
```

反射机制所需的类主要有java.lang包中的Class类和java.lang.reflect包中的Constructor类（构造方法）、Field类（属性）、Method类（普通方法）和Parameter类（参数）。



### 二、反射机制原理示意图

---

![image-20230214105924189](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230214114047166-1660299677.png)

### 二、反射能做什么

---

```markdown
# 在运行时判断任意一个对象所属的类
# 在运行时构造任意一个类的对象
# 在运行时得到任意一个类所具有的成员变量和方法
# 在运行时调用任意一个对象的成员变量和方法
# 生成动态代理
```



### 三、学习反射学的是什么？

---

反射是通过 class 字节码文件生成 Class 的对象然后获取里面的内容

```markdown
- 如何从 class 字节码文件中获取对象 (Class 对象 ）
- 如何获取构造方法 （ 创建对象 ）
- 如何获取属性 （ 赋值取值 ）
- 如何获取其他方法 （ 调用 ）
```

#### 1.Class的常用方法

![image-20230214160549450](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230214161218025-223602413.png)

#### 2.获取字节码对象

##### 2-1.Class类中的静态方法

```java
Class.forName("com.Student");
```

##### 2-2.通过类的clazz属性

```java
Student.class;
```

##### 2-3.通过对象来获得字节码文件对象

```java
Student student = new Student();
Class<? extends Student> aClass = student.getClass();
```

##### 2-4.理解

```markdown
* java 文件 ： 就是我们建立书写的 java 代码文件
* 字节码文件 ： 通过 java 文件翻译之后 class 文件 （ 存在硬盘 ， 真实可见 ）
* 字节码文件对象 ：当class文件加载内存之后，虚拟机自动创建出来的对象这个对象会包含构造器、属性、如何获取其他方法
```

我们反射获得的就是字节码对象 ， 在内存中和硬盘中都是唯一的

#### 3.获取构造方法

方法类似但是方法中使用不同的规则来获取不同的构造方法 ：

get（获取）constructor（构造方法）DecIared（表示私有）最后的s表示复数（所有）

前置操作(获取字节码文件对象):

```java
Class<?> aClass = Class.forName("com.Student");
```

##### 3-1.获取构造方法(公共、所有)的对象

```java
aClass.getConstructors();
```

##### 3-2.获取构造方法(公共、私有、所有)的对象

```java
aClass.getDeclaredConstructors();
```

##### 3-3.获取无参或带参(参数需要类的字节码文件)构造方法

```java
aClass.getConstructor();
aClass.getConstructor(String.class, int.class);
//下面的可以获取指定的构造方法，但是与上面不同的是还可以获取私有构造方法
aClass.getDeclaredConstructor(String.class);
```

#### 4.创建对象

构造方法的作用 ：

```markdown
- 创建对象
- 创建对象时为对象的属性赋值
```

前置操作

```java
//获取字节码文件对象
//获取无参构造方法
```

##### 4-1.newlnstance() 创建对象的方法

```java
constructor.newInstance();
```

##### 4-2.setAccessibte(true) 设置临时访问权限  private 可以访问

```java
declaredConstructor.setAccessible(true);
```

#### 5.获取成员变量（属性）

get（表示获取）Declared（表示私有）s（表示复数）
如果获取的属性是私有的需要添加临时访问权限

前置操作

```java
//获取字节码文件对象
```

##### 5-1.获取成员变量对象数组 (public)

```java
aClass.getFields();
```

##### 5-2.获取成员变量对象数组（ 包含 private)

```java
aClass.getDeclaredFields();
```

##### 5-3.获取单个成员变量对象 (public)

```java
aClass.getField("name");
```

##### 5-4.获取单个成员变量对象 （ 包含 private)

```java
aClass.getDeclaredField("name");
name.setAccessible(true);
```

#### 6.为成员变量赋值或获取值

前置操作

```java
//获取字节码文件对象
//创建一个有属性的对象
//获取要操作的属性
```

##### 6-1.set()	赋值

```java
//设置属性的值(参数1：要修改的对象  参数2：要修改的值)
name.set(student, "李四");
```

##### 6-2.get()	获取值

```java
//获取属性的值(参数：要获取的对象)
Object o = name.get(student);
```

#### 7.获取方法

get（表示获取）Declared（表示私有）s（表示复数）
如果获取的属性是私有的需要添加临时访问权限

前置操作

```java
//获取字节码文件对象
//创建一个对象
```

##### 7-1.获取当前类与父类的所有公共方法

```java
aClass.getMethods();
```

##### 7-2.获取当前类与父类的所有方法

```java
aClass.getDeclaredMethods();
```

##### 7-3.获取公共的单个方法(参数1：方法名   参数2：方法参数)

```java
aClass.getMethod("sleep");
aClass.getMethod("eat", String.class);
```

##### 7-4.获取单个方法(参数1：方法名   参数2：方法参数)

```java
aClass.getDeclaredMethod("getName");
aClass.getDeclaredMethod("setName", String.class);
```

##### 7-5.调用方法

```java
sleep.invoke(student);
String invoke = (String) eat.invoke(student, "a");
```



### 四、反射的优点和缺点

- 优点 ：可以动态的创建和使用对象（ 也是框架底层核心 ），使用灵活，没有反射机制， 框架技术就失去底层支撑 。

- 缺点 ：使用反射基本是解释执行，对执行速度有影响。



部分笔记来源于：[韩顺平 (bilibili.com)](https://space.bilibili.com/651245581)
