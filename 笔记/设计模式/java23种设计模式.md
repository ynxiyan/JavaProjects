# [java23种设计模式](https://www.cnblogs.com/ynxiyan/p/17068851.html)

### 一、创建者模式

创建型模式的主要关注点是“怎样创建对象？”，它的主要特点是“将对象的创建与使用分离”。

这样可以降低系统的耦合度，使用者不需要关注对象的创建细节。

创建型模式分为：

```markdown
# 单例模式
# 工厂方法模式
# 抽象工程模式
# 原型模式
# 建造者模式
```



#### 1.单例设计模式

----

单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

##### 1-1.单例模式的结构

单例模式的主要有以下角色：

```markdown
# 单例类。只能创建一个实例的类
# 访问类。使用单例类
```

##### 1-2.单例模式的实现

单例设计模式分类两种：

```markdown
- 饿汉式：类加载就会导致该单实例对象被创建	
- 懒汉式：类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建
```

1. **饿汉式-方式1（静态变量方式）**

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 14:25
    * @注释:饿汉式--静态成员变量
    */
   public class Singleton {
       //私有构造方法
       private Singleton() {
       }
   
       //在本类中创建本类对象
       private static Singleton singleton = new Singleton();
   
       //提供一个公共的访问方式，让外界获取该对象
       public static Singleton getSingleton() {
           return singleton;
       }
   }
   ```

   <font color='red'>说明：</font>

   ​	该方式在成员位置声明Singleton类型的静态变量，并创建Singleton类的对象instance。instance对象是随着类的加载而创建的。如果该对象足够大的话，而一直没有使用就会造成内存的浪费。

2. **饿汉式-方式2（静态代码块方式）**

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 14:35
    * @注释:饿汉式--静态代码块
    */
   public class Singleton {
       //私有构造方法
   
       private Singleton() {
       }
   
       //声明Singleton类型的变量
       private static Singleton singleton;
   
       //在静态代码块中赋值
       static {
           singleton = new Singleton();
       }
   
       //对外提供获取该对象的公共方法
       public static Singleton getSingleton() {
           return singleton;
       }
   }
   ```

   <font color='red'>说明：</font>

   ​	该方式在成员位置声明Singleton类型的静态变量，而对象的创建是在静态代码块中，也是对着类的加载而创建。所以和饿汉式的方式1基本上一样，当然该方式也存在内存浪费问题。

3. **懒汉式-方式2（线程安全）**

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 15:18
    * @注释:懒汉式--线程不安全
    */
   public class Singleton {
       //私有构造方法
       private Singleton() {
       }
   
       //声明Singleton类型的变量
       private static Singleton singleton;
   
       //对外提供公共方法   synchronized--同步
       public static synchronized Singleton getSingleton() {
           //判断singleton是否为null，如果为null说明Singleton对象还未创建
           if (singleton == null) {
               singleton = new Singleton();
           }
           return singleton;
       }
   }
   ```

   <font color='red'>说明：</font>

   ​	该方式也实现了懒加载效果，同时又解决了线程安全问题。但是在getInstance()方法上添加了synchronized关键字，导致该方法的执行效果特别低。从上面代码我们可以看出，其实就是在初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在了。

5. **懒汉式-方式3（双重检查锁）**

   再来讨论一下懒汉模式中加锁的问题，对于 `getInstance()` 方法来说，绝大部分的操作都是读操作，读操作是线程安全的，所以我们没必让每个线程必须持有锁才能调用该方法，我们需要调整加锁的时机。由此也产生了一种新的实现模式：双重检查锁模式

   ```markdown
   双重检查锁模式是一种非常好的单例实现模式，解决了单例、性能、线程安全问题，上面的双重检测锁模式看上去完美无缺，其实是存在问题，在多线程的情况下，可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。
   ```
   
   要解决双重检查锁模式带来空指针异常的问题，只需要使用 `volatile` 关键字, `volatile` 关键字可以保证可见性和有序性。
   
   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 15:53
    * @注释:懒汉式--双重检查锁
    */
   public class Singleton {
       //私有构造方法
       private Singleton() {
       }
   
       //声明Singleton类型的变量  volatile--解决双重锁带来的空指针异常问题
       private static volatile Singleton singleton;
   
       //对外提供公共方法
       public static synchronized Singleton getSingleton() {
           //第一次判断，如果Singleton不为null，不进入抢锁阶段，直接返回实例
           if (singleton == null) {
               synchronized (Singleton.class) {
                   //抢到锁后再次判断Singleton是否为null
                   if (singleton == null) {
                       singleton = new Singleton();
                   }
               }
           }
           return singleton;
       }
   }
   ```
   
   <font color="red">小结：</font>
   
   添加 `volatile` 关键字之后的双重检查锁模式是一种比较好的单例实现模式，能够保证在多线程的情况下线程安全也不会有性能问题。


6. **懒汉式-方式4（静态内部类方式）**

   静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。静态属性由于被 `static` 修饰，保证只被实例化一次，并且严格保证实例化顺序。

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 16:15
    * @注释:懒汉式--静态内部类
    */
   public class Singlrton {
       //私有构造方法
       private Singlrton() {
       }
   
       //静态内部类
       public static class StaSingleton {
           //创建Singleton类型的常量
           private static final Singlrton SINGLETON = new Singlrton();
       }
   
       //提供公共访问方法
       public static Singlrton getInstance() {
           return StaSingleton.SINGLETON;
       }
   }
   ```

   <font color='red'>说明：</font>

   ​	第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，虚拟机加载SingletonHolder

   并初始化INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性。

   <font color="red">小结：</font>

   ​	静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。

7. **枚举方式**

   枚举类实现单例模式是极力推荐的单例实现模式，因为枚举类型是线程安全的，并且只会装载一次，设计者充分的利用了枚举的这个特性来实现单例模式，枚举的写法非常简单，而且枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式。

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/6 16:27
    * @注释:恶汉式--枚举方式
    */
   public enum Singleton {
       SINGLETON;
   }
   ```

   <font color='red'>说明：</font>
   
   ​	枚举方式属于恶汉式方式。
   
   **测试**
   
   ```java
   public class Test {
       public static void main(String[] args) {
           //创建Singleton对象
           Singleton singleton = Singleton.getInstance();
           Singleton singleton1 = Singleton.getInstance();
           //判断是否是同一对象
           System.out.println(singleton == singleton1);
       }
   }
   ```
   
   ```java
   public class Test {
       public static void main(String[] args) {
           Singleton singleton = Singleton.SINGLETON;
           Singleton singleton1 = Singleton.SINGLETON;
           System.out.println(singleton == singleton1);
       }
   }
   ```

##### 存在的问题

破坏单例模式：

使上面定义的单例类（Singleton）可以创建多个对象，枚举方式除外。有两种方式，分别是序列化和反射。

- **Singleton：**

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/2/7 10:30
   * @注释:反射破坏单例模式
   */
  public class Singleton {
      //私有构造方法
      private Singleton() {
      }
  
      //静态内部类
      public static class staSingleton {
          //创建Singleton类型的常量
          private static final Singleton SINGLETON = new Singleton();
      }
  
      //提供公共访问方法
      public static Singleton getInstance() {
          return staSingleton.SINGLETON;
      }
  }
  ```
- 序列化反序列化

  **Test:**

  ```java
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
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\itheima\\pattern\\singleton\\demo7\\io\\a.txt"));
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
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\itheima\\pattern\\singleton\\demo7\\io\\a.txt"));
          //3.写对象
          oos.writeObject(singleton);
          //4.释放资源
          oos.close();
      }
  }
  ```

  > 上面代码运行结果是`false`，表明序列化和反序列化已经破坏了单例设计模式。

* 反射

  **Test：**

  ```java
  public class Test {
      public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
          //1.获取Singleton的字节码对象
          Class c = Singleton.class;
          //2.获取无参构造方法对象
          Constructor constructor = c.getDeclaredConstructor();
          //3.取消访问检查
          constructor.setAccessible(true);
          //4.创建Singleton对象
          Singleton singleton = (Singleton) constructor.newInstance();
          Singleton singleton1 = (Singleton) constructor.newInstance();
          //如果返回true，说明没有破坏单例模式，反之则破坏单例模式
          System.out.println(singleton == singleton1);
      }
  ```


> <font color="red">注意：</font>枚举方式不会出现这两个问题。

##### 问题的解决

* 序列化、反序列方式破坏单例模式的解决方法

  在Singleton类中添加`readResolve()`方法，在反序列化时被反射调用，如果定义了这个方法，就返回这个方法的值，如果没有定义，则返回新new出来的对象。

  **Singleton：**

  ```java
  public class Singleton {
      ...
      //当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
      public Object readResolve() {
          return staSingleton.SINGLETON;
      }
  }
  ```

- 反射方式破解单例的解决方法

  **Singleton:**

  ```java
  public class Singleton {
      private static boolean flag=false;
      //私有构造方法
      private Singleton() {
          synchronized (Singleton.class){
              //判断flag是否为true，如果为true说明并非第一次访问无参构造方法，抛出异常
              if(flag){
                  throw new RuntimeException("不能创建多个对象！");
              }
              flag=true;
          }
      }
  ...
  }
  ```

<font color="red">说明:</font>

​	这种方式比较好理解。当通过反射方式调用构造方法进行创建创建时，直接抛异常。不运行此中操作。



#### 2.工厂模式

---

**概述**

在java中，万物皆对象，这些对象都需要创建，如果创建的时候直接new该对象，就会对该对象耦合严重，假如我们要更换对象，所有new对象的地方都需要修改一遍，这显然违背了软件设计的开闭原则。如果我们使用工厂来生产对象，我们就只和工厂打交道就可以了，彻底和对象解耦，如果要更换对象，直接在工厂里更换该对象即可，达到了与对象解耦的目的；所以说，工厂模式最大的优点就是：**解耦**。

三种工厂

```markdown
# 简单工厂模式（不属于GOF的23种经典设计模式）
# 工厂方法模式
# 抽象工厂模式
```

##### 2-1.简单工厂模式

简单工厂不是一种设计模式，反而比较像是一种编程习惯。

**结构**

简单工厂包含如下角色：

```markdown
- 抽象产品 ：定义了产品的规范，描述了产品的主要特性和功能。
- 具体产品 ：实现或者继承抽象产品的子类
- 具体工厂 ：提供了创建产品的方法，调用者通过该方法来获取产品。
```

**实现**

现在使用简单工厂对上面案例进行改进，类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192231098-2130573847.png)

咖啡：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:06
 * @注释:咖啡类
 */
public abstract class Coffee {
    public abstract String getName();
    //加糖
    public void addSugar() {
        System.out.println("加糖");
    }
    //加奶
    public void addMilk() {
        System.out.println("加奶");
    }
}
```

工厂类：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:18
 * @注释:简单咖啡工厂，用来生产咖啡
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据判断创建不同类型的Coffee子对象
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latter".equals(type)) {
            coffee = new LatterCoffee();
        } else {
            System.out.println("对不起，您点的咖啡种类不存在");
        }
        return coffee;
    }
}
```

咖啡商店：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:26
 * @注释:咖啡商店
 */
public class CoffeeStore {
    public Coffee coffee(String type) {
        SimpleCoffeeFactory scf = new SimpleCoffeeFactory();
        //调用生产咖啡方法
        Coffee coffee = scf.createCoffee(type);
        //加料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.coffee("latter");
        System.out.println(coffee.getName());
    }
}
```

工厂（factory）处理创建对象的细节，一旦有了SimpleCoffeeFactory，CoffeeStore类中的orderCoffee()就变成此对象的客户，后期如果需要Coffee对象直接从工厂中获取即可。这样也就解除了和Coffee实现类的耦合，同时又产生了新的耦合，CoffeeStore对象和SimpleCoffeeFactory工厂对象的耦合，工厂对象和商品对象的耦合。

后期如果再加新品种的咖啡，我们势必要需求修改SimpleCoffeeFactory的代码，违反了开闭原则。工厂类的客户端可能有很多，比如创建美团外卖等，这样只需要修改工厂类的代码，省去其他的修改操作。

**优点：**

- 封装了创建对象的过程，可以通过参数直接获取对象。把对象的创建和业务逻辑层分开，这样以后就避免了修改客户代码，如果要实现新产品直接修改工厂类，而不需要在原代码中修改，这样就降低了客户代码修改的可能性，更加容易扩展。

**缺点：**

- 增加新产品时还是需要修改工厂类的代码，违背了“开闭原则”。

**扩展**

静态工厂

在开发中也有一部分人将工厂类中的创建对象的功能定义为静态的，这个就是静态工厂模式，它也不是23种设计模式中的。

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:18
 * @注释:简单静态咖啡工厂，用来生产咖啡
 */
public class SimpleCoffeeFactory {
    public static Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据判断创建不同类型的Coffee子对象
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latter".equals(type)) {
            coffee = new LatterCoffee();
        } else {
            System.out.println("对不起，您点的咖啡种类不存在");
        }
        return coffee;
    }
}
```

咖啡商店：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:26
 * @注释:咖啡商店
 */
public class CoffeeStore {
    public Coffee coffee(String type) {
        //调用生产咖啡方法
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);
        //加料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
```



##### 2-2.工厂方法模式

针对上例中的缺点，使用工厂方法模式就可以完美的解决，完全遵循开闭原则。

**概念**

定义一个用于创建对象的接口，让子类决定实例化哪个产品类对象。工厂方法使一个产品类的实例化延迟到其工厂的子类。

**结构**

工厂方法模式的主要角色：

```markdown
- 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。
- 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
- 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
- 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
```

**实现**

使用工厂方法模式对上例进行改进，类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192230742-1080622378.png)

抽象工厂：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:06
 * @注释:咖啡接口--抽象工厂
 */
public interface CoffeeFactory {
    /**
     * 创建咖啡对象方法
     * @return
     */
    Coffee createCoffee();
}
```

具体工厂：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:10
 * @注释:美式咖啡工厂对象，用来生产美式咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    /**
     * 创建咖啡对象方法
     *
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:11
 * @注释:拿铁咖啡工厂，用来生产拿铁咖啡
 */
public class LatterCoffeeFactory implements CoffeeFactory {

    /**
     * 创建咖啡对象方法
     *
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new LatterCoffee();
    }
}
```

咖啡商店：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:26
 * @注释:咖啡商店
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    //点咖啡方法
    public Coffee coffee() {
        Coffee coffee = factory.createCoffee();
        //加料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        //创建咖啡商店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        //创建对象
        //CoffeeFactory factory=new AmericanCoffeeFactory();
        CoffeeFactory factory = new LatterCoffeeFactory();
        coffeeStore.setFactory(factory);
        //点咖啡
        Coffee coffee = coffeeStore.coffee();
        System.out.println(coffee.getName());
    }
}
```

从以上的编写的代码可以看到，要增加产品类时也要相应地增加工厂类，不需要修改工厂类的代码了，这样就解决了简单工厂模式的缺点。

工厂方法模式是简单工厂模式的进一步抽象。由于使用了多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。

**优点：**

- 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
- 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；

**缺点：**

* 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。

##### 2-3.抽象工厂模式

前面介绍的工厂方法模式中考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机、传智播客只培养计算机软件专业的学生等。

这些工厂只生产同种类产品，同种类产品称为同等级产品，也就是说：工厂方法模式只考虑生产同等级的产品，但是在现实生活中许多工厂是综合型的工厂，能生产多等级（种类） 的产品，如电器厂既生产电视机又生产洗衣机或空调，大学既有软件专业又有生物专业等。

本节要介绍的抽象工厂模式将考虑多等级产品的生产，将同一个具体工厂所生产的位于不同等级的一组产品称为一个产品族，下图所示横轴是产品等级，也就是同一类产品；纵轴是产品族，也就是同一品牌的产品，同一品牌的产品产自同一个工厂。

**概念**

是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。

抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。

**结构**

抽象工厂模式的主要角色如下：

```markdown
- 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法，可以创建多个不同等级的产品。
- 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
- 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
- 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。
```

**实现**

现咖啡店业务发生改变，不仅要生产咖啡还要生产甜点，如提拉米苏、抹茶慕斯等，要是按照工厂方法模式，需要定义提拉米苏类、抹茶慕斯类、提拉米苏工厂、抹茶慕斯工厂、甜点工厂类，很容易发生类爆炸情况。其中拿铁咖啡、美式咖啡是一个产品等级，都是咖啡；提拉米苏、抹茶慕斯也是一个产品等级；拿铁咖啡和提拉米苏是同一产品族（也就是都属于意大利风味），美式咖啡和抹茶慕斯是同一产品族（也就是都属于美式风味）。所以这个案例可以使用抽象工厂模式实现。类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192230382-262368060.png)

抽象工厂：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:49
 * @注释:商店接口--抽象工厂
 */
public interface Factory {
    //生产咖啡
    Coffee createCoffee();

    //生产甜品
    Dessert createDessert();
}
```

具体工厂：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:53
 * @注释:美式风味工厂，生产美式咖啡和抹茶慕斯
 */
public class AmericanFactory implements Factory {
    /**
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    /**
     * @return
     */
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:55
 * @注释:意大利风味工厂，生产拿铁咖啡和提拉米苏
 */
public class ItalyFactory implements Factory {
    /**
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new LatterCoffee();
    }

    /**
     * @return
     */
    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        //创建意大利风味工厂对象
        //ItalyFactory factory = new ItalyFactory();
        //创建美式风味工厂对象
        AmericanFactory factory = new AmericanFactory();
        //获取拿铁咖啡和提拉米苏
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}
```

如果要加同一个产品族的话，只需要再加一个对应的工厂类即可，不需要修改其他的类。

**优点：**

- 当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。

**缺点：**

- 当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。

**使用场景**

```markdown
# 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
# 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
# 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
```

如：输入法换皮肤，一整套一起换。生成不同操作系统的程序。

##### 2-4.模式扩展

**简单工厂+配置文件解除耦合**

可以通过工厂模式+配置文件的方式解除工厂对象和产品对象的耦合。在工厂类中加载配置文件中的全类名，并创建对象进行存储，客户端如果需要对象，直接进行获取即可。

第一步：定义配置文件

为了演示方便，我们使用properties文件作为配置文件，名称为bean.properties

```properties
american=com.itheima.pattern.factory.config.AmericanCoffee
latter=com.itheima.pattern.factory.config.LatterCoffee
```

第二步：咖啡工厂--加载配置文件

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/7 18:28
 * @注释:加载配置文件，获取配置文件中配置的全类名并创建该类对象进行存储
 */
public class CoffeeFactory {
    //1.定义容器对象存储咖啡对象
    private static Map<String, Coffee> map = new HashMap<>();

    //2.加载配置文件（只需加载一次）
    static {
        //3.创建properties对象
        Properties properties = new Properties();
        //4.调用properties的load()方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(is);
            //5.从map集合中获取全类名并创建对象
            Set set = properties.keySet();
            for (Object o : set) {
                String className = properties.getProperty((String) o);
                //6.通过反射创建对象
                Class c = Class.forName(className);
                Coffee coffee = (Coffee) c.newInstance();
                //7.将名称和对象存储到容器里
                map.put((String) o, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //8.根据名称获取对象
    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
```

测试

```java
public class Test {
    public static void main(String[] args) {
        Coffee coffee=CoffeeFactory.createCoffee("latter");
        //Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());
    }
}
```

静态成员变量用来存储创建的对象（键存储的是名称，值存储的是对应的对象），而读取配置文件以及创建对象写在静态代码块中，目的就是只需要执行一次。



#### 3.原型模式

---

**概述**

用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象。

**结构**

原型模式包含如下角色：

```markdown
- 抽象原型类：规定了具体原型对象必须实现的的 clone() 方法。
- 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
- 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
```

**实现**

原型模式的克隆分为浅克隆和深克隆。

> 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
>
> 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。

Java中的Object类中提供了 `clone()` 方法来实现浅克隆。 Cloneable 接口是上面的类图中的抽象原型类，而实现了Cloneable接口的子实现类就是具体的原型类。

**用原型模式生成“三好学生”奖状**

同一学校的“三好学生”奖状除了获奖人姓名不同，其他都相同，可以使用原型模式复制多个“三好学生”奖状出来，然后在修改奖状上的名字即可。

类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192230014-1859883273.png)

```java
//实现可克隆接口
public class Citation implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(name);
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建一个原型对象
        Citation citation = new Citation();
        //调用clone()方法进行对象的克隆
        Citation citation1 = citation.clone();
        citation.setName("张三");
        citation1.setName("李四");
        citation.show();
        citation1.show();
    }
}
```

**使用场景**

* 对象的创建非常复杂，可以使用原型模式快捷的创建对象。
* 性能和安全要求比较高。



##### **3-1.扩展（深克隆）**

<font color="red">说明：</font>

对具体原型类（Citation）中的引用类型的属性进行引用的复制。这种情况需要使用深克隆，而进行深克隆需要使用对象流。

Student：

```java
//实现序列化接口
public class Student implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

Citation：

```java
//实现可克隆接口和序列化接口
public class Citation implements Cloneable, Serializable {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(student.getName());
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) throws Exception {
        //创建一个原型对象
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        citation.setStudent(student);
        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\itheima\\pattern\\prototype\\io\\a.txt"));
        //写对象
        oos.writeObject(citation);
        //释放资源
        oos.close();
        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\itheima\\pattern\\prototype\\io\\a.txt"));
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
```

> 注意：Citation类和Student类必须实现Serializable接口，否则会抛NotSerializableException异常。



#### 4.建造者模式

---

**概述**

将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。

```markdown
# 分离了部件的构造(由Builder来负责)和装配(由Director负责)。 从而可以构造出复杂的对象。这个模式适用于：某个对象的构建过程复杂的情况。
# 由于实现了构建和装配的解耦。不同的构建器，相同的装配，也可以做出不同的对象；相同的构建器，不同的装配顺序也可以做出不同的对象。也就是实现了构建算法、装配算法的解耦，实现了更好的复用。
# 建造者模式可以将部件和其组装过程分开，一步一步创建一个复杂的对象。用户只需要指定复杂对象的类型就可以得到该对象，而无须知道其内部的具体构造细节。
```

**结构**

建造者（Builder）模式包含如下角色：

```markdown
* 抽象建造者类（Builder）：这个接口规定要实现复杂对象的那些部分的创建，并不涉及具体的部件对象的创建。 
* 具体建造者类（ConcreteBuilder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。在构造过程完成后，提供产品的实例。 
* 产品类（Product）：要创建的复杂对象。
* 指挥者类（Director）：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。 
```

类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192229501-1704679628.png)

**创建共享单车**

生产自行车是一个复杂的过程，它包含了车架，车座等组件的生产。而车架又有碳纤维，铝合金等材质的，车座有橡胶，真皮等材质。对于自行车的生产就可以使用建造者模式。

这里Bike是产品，包含车架，车座等组件；Builder是抽象建造者，MobikeBuilder和OfoBuilder是具体的建造者；Director是指挥者。类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230208192228765-1775351080.png)

自行车类：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:36
 * @注释:自行车类
 */
public class Bike {
    private String frame;
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
```

抽象构建者：

```java
public abstract class Builder {
    //声明Bike类型的对象，并赋值
    protected Bike bike = new Bike();

    public abstract void builframe();

    public abstract void builseat();

    //构建自行车
    public abstract Bike createBike();
}
```

具体构建者:

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:42
 * @注释:具体构建者,用来构建膜拜自行车对象
 */
public class mobileBuilder extends Builder {
    /**
     * 构建车架
     */
    @Override
    public void builframe() {
        bike.setFrame("膜拜车架");
    }

    /**
     * 构建坐垫
     */
    @Override
    public void builseat() {
        bike.setSeat("膜拜坐垫");
    }

    /**
     * 构建自行车
     *
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:47
 * @注释:具体构建者，用来构建共享自行车
 */
public class ofoBuilder extends Builder {
    /**
     * 构建车架
     */
    @Override
    public void builframe() {
        bike.setFrame("共享车架");
    }

    /**
     * 构建坐垫
     */
    @Override
    public void builseat() {
        bike.setSeat("共享坐垫");
    }

    /**
     * 构建自行车
     *
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
```

指挥者类:

```java
public class Director {
    //声明Builder类型的变量
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //组装自行车
    public Bike construct() {
        builder.builframe();
        builder.builseat();
        return builder.createBike();
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new mobileBuilder());
        //让指挥者组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame() + "\t" + bike.getSeat());
    }
}
```

**优点：**

- 建造者模式的封装性很好。使用建造者模式可以有效的封装变化，在使用建造者模式的场景中，一般产品类和建造者类是比较稳定的，因此，将主要的业务逻辑封装在指挥者类中对整体而言可以取得比较好的稳定性。
- 在建造者模式中，客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。
- 可以更加精细地控制产品的创建过程 。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
- 建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成，基本上不用修改之前已经测试通过的代码，因此也就不会对原有功能引入风险。符合开闭原则。

**缺点：**

- 造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。

**使用场景**

建造者（Builder）模式创建的是复杂对象，其产品的各个部分经常面临着剧烈的变化，但将它们组合在一起的算法却相对稳定，所以它通常在以下场合使用。

```markdown
- 创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
- 创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。
```

##### **4-1.模式扩展**

建造者模式除了上面的用途外，在开发中还有一个常用的使用方式，就是当一个类构造器需要传入很多参数时，如果创建这个类的实例，代码可读性会非常差，而且很容易引入错误，此时就可以利用建造者模式进行重构。

Phone类:

```java
public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String mainBoard;

    //私有构造方法
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainBoard = builder.mainBoard;
    }

    //静态内部类
    public static class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainBoard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        //使用构建者创建Phone对象
        public Phone builder() {
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                '}';
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("高通CPU")
                .screen("三星屏幕")
                .memory("联发科内存")
                .mainBoard("华为主板")
                .builder();
        System.out.println(phone);
    }
}
```

重构后的代码在使用起来更方便，某种程度上也可以提高开发效率。从软件设计上，对程序员的要求比较高。



#### 5.创建者模式对比

---

##### 5-1.工厂方法模式VS建造者模式

```markdown
# 工厂方法模式注重的是整体对象的创建方式；而建造者模式注重的是部件构建的过程，意在通过一步一步地精确构造创建出一个复杂的对象。
```

##### 5-2.抽象工厂模式VS建造者模式

```markdown
# 抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品：具有不同分类维度的产品组合，采用抽象工厂模式则是不需要关心构建过程，只关心什么产品由什么工厂生产即可。
# 建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品。
# 如果将抽象工厂模式看成汽车配件生产工厂，生产一个产品族的产品，那么建造者模式就是一个汽车组装工厂，通过对部件的组装可以返回一辆完整的汽车。
```



# 未完待续。。。。。。。

所有笔记来源于：[黑马程序员 (bilibili.com)](https://space.bilibili.com/37974444)
