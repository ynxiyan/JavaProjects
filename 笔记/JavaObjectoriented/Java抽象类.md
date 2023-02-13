# [Java抽象类](https://www.cnblogs.com/ynxiyan/p/17037573.html)

### **一、什么是抽象类**

由abstract修饰的方法叫抽象方法；由abstract修饰的类叫抽象类。抽象的类无法进行实例化，因为他不是具体存在的类，或者说这样的类还不够完善，不能直接使用new关键字调用其构造器生成该类的对象。我们可以使用abstract定义一个抽象类和抽象方法，示例代码如下：

```java
abstract class 类名
	{
		abstract int 方法名(int x,int y);
	}
```

抽象的方法没有方法体。需要注意的是在抽象类中既可以有抽象方法，也可以有普通方法，注意抽象方法是没有方法体的（也就是方法后面是没有大括号的）。凡是继承这个抽象类的实体子类，都必须要实现这个抽象方法。

我们总结一下抽象类的特点：

```markdown
（1）抽象类不能被实例化
（2）构造方法 和 static 方法不能是抽象的
（3）父类的抽象方法往往在子类中实现
（4）抽象类可以具有指向子类对象的对象引用
```

### **二、抽象类的例子**

我们先来看看要完成的实际例子：

1、定义抽象类员工Employee,

（a）保护字段：姓名name,性别gender，年龄age等基本属性。

（b）定义抽象方法函数getsalary()表示领工资的操作

（c）定义普通函数whoami()输出 ：我是+姓名

（d）拥有（姓名name,性别gender）参数的构造函数

定义一个经理类Manager 派生于员工；

（a）除了有员工等基本属性外，还有岗位级别 gree私有属性

（b）经理领7000元工资，打印并输出工资。

（c）重写父类的whoami(),调用父类的whoami()方法，再输出：我是一名经理。

```java
/**
 * 定义类员工Employee,
 */
public abstract class Employee {
    protected String name;
    protected boolean gender;
    protected int age;
    public Employee(String name,boolean gender){
        this.name=name;
        this.gender=gender;
    }
    /**
    * 表示领工资的操作
    */
    public abstract void getsalary();
    public void whoami(){
        System.out.println("我是"+name);
    }
}
```

我们新建一个经理类Manager，继承Employee类，这时候Eclipse就提示我们必须要重写抽象方法getsalary。示例代码如下：

```java
/**
 * 经理类
 */
public class Manager extends Employee{
    private String gree;
    
    public Manager(String name,boolean gender){
        super(name,gender);
    }
    //重写父类的抽象方法
    public void getsalary(){
        System.out.println("经理领7000元工资");
    }
 
    public void whoami(){
        super.whoami();//显示调用父类的方法
        System.out.println("我是经理");
    }
}
```

原文链接：https://www.cnblogs.com/weibanggang/p/11184671.html