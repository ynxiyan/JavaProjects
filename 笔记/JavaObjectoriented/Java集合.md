# [Java集合](https://www.cnblogs.com/ynxiyan/p/17068839.html)

### 一、什么是集合


![image-20230110171001018](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131728714-990752540.png)



### 二、Collection体系集合


![image-20230110171437368](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131728276-410264617.png)



#### 1.Collection父接口

---

![image-20230110171822427](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131727285-1483010433.png)



#### 2.List集合

---

![image-20230111143914189](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131725888-758181426.png)

- **方法**（list继承collection）

  ```java
      public static void main(String[] args) {
          //创建list集合
          List list = new ArrayList<>();
          //通过下标添加元素
          list.add(0, "a");
          //返回元素个数
          //通过下标删除元素(保存int型数据时默认调用remove(下标),需将要删除的数字转成(Object)或new Integer())
          list.remove(0);
          //遍历元素
          System.out.println("1.使用for");
          for (int i = 0; i < list.size(); i++) {
              System.out.print(list.get(i) + "");
          }
          //list迭代器（正向、逆向）
          ListIterator listIterator =list.listIterator();
          System.out.println("\n正向");
          while (listIterator.hasNext()) {
              //获取下一个元素的下标和值
              System.out.print("["+listIterator.nextIndex()+"]"+(String)listIterator.next()+"");
          }
          System.out.println("\n逆向");
          //判断有没有上一个元素，返回boolean
          while (listIterator.hasPrevious()) {
              //获取上一个元素的下标和值
              System.out.print("["+listIterator.previousIndex()+"]"+listIterator.previous()+"");
          }
          //判断
          //获取元素位置
          System.out.println(list.indexOf("e"));
          //返回子集合
          List subList=list.subList(1,3); //开始位置，结束位置（使用下标）
      }
  ```

##### 1.list实现类

---

- **ArrayLIst**

  数组结构实现 ， 查询快 、 增删慢 ；

  JDK1. 2 版本 ， 运行效率快 、 线程不安全 。

  - 源码分析：

    默认容量：DEFAULT_CAPACITY = 10 ；

    - 注意：如果没有向集合中添加任何元素，则容量为0

    存放元素的数组：elementData

    实际元素个数：size
  
- **Vector**

  ![](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131725337-1886705343.png)
  
    

- **LinkedList**

  ![image-20230111170532826](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131725010-1857680315.png)

#### 3.Set集合

##### 1.Set子接口

---

![image-20230114155142186](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131724692-1233591178.png)



##### 2.Set实现类

---

- **HashSet**

  ![image-20230114163521392](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131724379-1909954499.png)

  方法

  ```java
  /**
   * 存储结构：哈希表（数组+链表+红黑树）
   * 存储过程：
   * 1.根据hashcode计算保存位置，如果位置为空则直接保存，否则执行下一步
   * 2.执行equals方法，如果equals返回true则为重复元素，否则形成链表
   */
  public class Demo1 {
      /*
      1.添加元素
      2.删除元素
      3.遍历元素
      4.判断
       */
      public static void main(String[] args) {
          //创建Set<String>集合
          HashSet<String> hashSet = new HashSet();
          //添加元素
          hashSet.add("b");
          hashSet.add("c");
          hashSet.add("d");
          hashSet.add("e");
          //返回元素个数
          System.out.println(hashSet.size());
          //返回元素集合
          System.out.println("返回元素集合：");
          System.out.println(hashSet);
          //删除元素
          hashSet.remove("c");
          //删除所有
          //list.clear();
          System.out.println("删除元素后：");
          System.out.println(hashSet);
          //遍历元素
          System.out.println("1.使用增强for");
          for (String s : hashSet) {
              System.out.print(s + "");
          }
          System.out.println("\n2.使用迭代器");
          //迭代器
          Iterator<String> iterator = hashSet.iterator();
          while (iterator.hasNext()) {
              System.out.print(iterator.next() + "");
          }
          System.out.println();
          //判断
          System.out.println(hashSet.contains("d"));
          System.out.println(hashSet.isEmpty());
      }
  }
  ```

- **TreeSet**

  ![image-20230114163619252](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131723958-83476457.png)

  方法

  ```java
  public class Student implements Comparable<Student> {
      ...
      /**
       * 先按姓名比较，然后再按年龄比较
       *
       * @param o the object to be compared.
       * @return
       */
      @Override
      public int compareTo(Student o) {
          int num1 = getName().compareTo(o.getName());
          int num2 = getAge() - o.getAge();
          return num1 == 0 ? num2 : num1;
      }
  }
  
  /**
   *TreeSet 存储结构：红黑树
   * 要求元素必须实现Comparable接口
   * compareTo方法返回0则认为是重复元素
   */
  public class Demo2 {
      /*
      1.添加元素
      2.删除元素
      3.遍历元素
      4.判断
       */
      public static void main(String[] args) {
          //创建TreeSet<Student>集合
  //        TreeSet<Student> treeSet = new TreeSet<>();
          /**
           * Comparator:实现定制比较（比较器）
           * Comparable:可比较的
           */
          //创建TreeSet<Student>集合并指定比较规则（无需实现Comparable接口）
          TreeSet<Student> treeSet = new TreeSet<>(new Comparator<Student>() {
              /**
               * 先按年龄比较，然后再按姓名比较
               * @param o1 the first object to be compared.
               * @param o2 the second object to be compared.
               * @return
               */
              @Override
              public int compare(Student o1, Student o2) {
                  int num1 = o1.getAge() - o2.getAge();
                  int num2 = o1.getName().compareTo(o2.getName());
                  return num1 == 0 ? num2 : num1;
              }
          });
          //实例化Student并赋值
          Student student1 = new Student("张三", 18);
          Student student2 = new Student("赵四", 20);
          Student student3 = new Student("李华", 16);
          //添加元素
          treeSet.add(student1);
          treeSet.add(student2);
          treeSet.add(student3);
          //返回元素个数
          System.out.println(treeSet.size());
          //返回元素集合
          System.out.println("返回元素集合：");
          System.out.println(treeSet);
          //删除元素
          treeSet.remove(student2);
          //删除所有
          //hashSet.clear();
          System.out.println("删除元素后：");
          System.out.println(treeSet);
          //遍历元素
          System.out.println("1.使用增强for");
          for (Student s : treeSet) {
              System.out.print(s + "");
          }
          System.out.println("\n2.使用迭代器");
          //迭代器
          Iterator<Student> iterator = treeSet.iterator();
          while (iterator.hasNext()) {
              System.out.print(iterator.next() + "");
          }
          System.out.println();
          //判断
          System.out.println(treeSet.contains(student2));
          System.out.println(treeSet.isEmpty());
      }
  }
  ```

  

### 三、ArrayList和LinkedList的区别

---

![image-20230114142609124](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131723241-353392111.png)



### 四、泛型

![image-20230114142705271](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131722659-1924668653.png)



#### 1.泛型类&泛型方法

---

```java
//使用泛型T(不能实例化！！！)
    //创建变量
    T t;

    public static void main(String[] args) {
        /**
         * 注意：
         * 1.泛型只能使用引用类型
         * 2.不同泛型类型的对象不能相互赋值
         */
        //创建泛型对象(String)
        Generic<String> generic = new Generic();
        generic.t = "泛型";
        generic.show(generic.getT());
        //创建泛型对象(Integer)
        Generic<Integer> generic1 = new Generic();
        generic1.t = 100;
        generic1.show(generic1.getT());
        Generic generic2 = new Generic();
        //泛型方法的实参无类型，实际类型以传入的数据为准！！！
        generic2.genshow(56.7);
        generic2.genshow("wwwww");

    }

    /**
     * 泛型作方法的参数
     */
    public void show(T t) {
        System.out.println(t);
    }

    /**
     * 泛型作方法的返回值
     *
     * @return
     */
    public T getT() {
        return t;
    }

    /**
     * 泛型方法(修饰符 <T> 返回值类型 方法名(参数类型 形参){方法体})
     * 好处：
     * 1.提高代码的重用性
     * 2.防止类型转换异常
     *
     * @param t
     * @param <T>
     */
    public <T> void genshow(T t) {
        System.out.println(t);
    }
```



#### 2.泛型接口

---

```java
public interface GenericService<T> {
    //注意：不能创建泛型静态常量！！！
    T show(T t);
}
```

```java
/**
* 注意：
* 1.作成泛型类:GenericServiceImpl<T> implements GenericService
* 2.确定引用类型:GenericServiceImpl implements GenericService<String>
**/
public class GenericServiceImpl implements GenericService<String> {
    public static void main(String[] args) {
        GenericServiceImpl genericServiceimpl = new GenericServiceImpl();
        genericServiceimpl.show("123");
    }

    @Override
    public String show(String s) {
        System.out.println(s);
        return s;
    }
}
```



#### 3.泛型集合

---

![image-20230114153111994](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131722119-409796720.png)

- **方法**

  ```java
   /**
   * 特点 ：
   * 1.编译时即可检查，而非运行时抛出异常。
   * 2.访问时，不必类型转换。
   * 3.不同泛型之间引用不能相互赋值，泛型不存在多态。
   */
  public class GenericList {
      public static void main(String[] args) {
          //泛型集合
          ArrayList<Student> arrayList = new ArrayList<>();
          //确认类型后编译时会检查，而非运行时报异常
          //arrayList.add("11111");
          arrayList.add(new Student("张三", 18));
          for (Student student : arrayList) {
              System.out.println(student);
          }
      }
  }
  ```

  

### 五、Map体系集合

![image-20230116150144253](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131721607-1253832510.png)



#### 1.Map父接口

---

![image-20230116150430824](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131721030-1189576909.png)



#### 2.Map实现类

---

- **HashMap**

  ![image-20230116160129573](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131720450-1258927044.png)

  ![image-20230116153240443](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131720093-761914610.png)

  方法：

  ```java
  /**
   *特点：
   * 1.存储键值对
   * 2.键不能重复，值可以重复
   * 3.无序
   */
  public class Demo1 {
      /*
      1.添加元素
      2.删除元素
      3.遍历元素
      4.判断
       */
      public static void main(String[] args) {
          //创建HashMap<Integer, String>集合
          HashMap<Integer, String> hashMap = new HashMap();
          //添加元素(键，值)
          hashMap.put(1, "b");
          hashMap.put(2, "c");
          hashMap.put(3, "d");
          hashMap.put(4, "e");
          //返回元素个数
          System.out.println(hashMap.size());
          //返回元素集合
          System.out.println("返回元素集合：");
          System.out.println(hashMap);
          //删除元素(key)
          hashMap.remove(2);
          //删除所有
          //hashMap.clear();
          System.out.println("删除元素后：");
          System.out.println(hashMap);
          //遍历元素
          System.out.println("1.使用keySet");
          for (Integer key : hashMap.keySet()) {
              //通过循环key得到对应的value
              System.out.println(key + "-" + hashMap.get(key));
          }
          System.out.println("\n2.使用entrySet");
          for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
              System.out.println(entry.getKey() + "-" + entry.getValue());
          }
          System.out.println();
          //判断
          System.out.println(hashMap.containsKey(2)); //通过键
          System.out.println(hashMap.containsValue("b")); //通过值
          System.out.println(hashMap.isEmpty());
      }
  }
  ```

![image-20230116160203774](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131719593-347451532.png)

- **TreeMap**

  ![image-20230116160607576](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131719207-82993175.png)

  方法：

  ```java
  public class Student implements Comparable<Student> {
      ...
      /**
       * 先按姓名比较，然后再按年龄比较
       *
       * @param o the object to be compared.
       * @return
       */
      @Override
      public int compareTo(Student o) {
          int num1 = getName().compareTo(o.getName());
          int num2 = getAge() - o.getAge();
          return num1 == 0 ? num2 : num1;
      }
  }
  
  /**
   *TreeMap 存储结构：红黑树
   * 要求元素必须实现Comparable接口
   * compareTo方法返回0则认为是重复元素
   */
  public class Demo2 {
      /*
      1.添加元素
      2.删除元素
      3.遍历元素
      4.判断
       */
      public static void main(String[] args) {
          //创建TreeMap<Student,String>集合
  //        TreeMap<Student,String> treeMap = new TreeMap<>();
          //创建TreeMap<Student,String>集合并指定比较规则（无需实现Comparable接口）
          TreeMap<Student, String> treeMap = new TreeMap<>(new Comparator<Student>() {
              /**
               * 先按年龄比较，然后再按姓名比较
               * @param o1 the first object to be compared.
               * @param o2 the second object to be compared.
               * @return
               */
              @Override
              public int compare(Student o1, Student o2) {
                  int num1 = o1.getAge() - o2.getAge();
                  int num2 = o1.getName().compareTo(o2.getName());
                  return num1 == 0 ? num2 : num1;
              }
          });
          //实例化Student并赋值
          Student student1 = new Student("张三", 18);
          Student student2 = new Student("赵四", 20);
          Student student3 = new Student("李华", 16);
          //添加元素
          treeMap.put(student1, "a");
          treeMap.put(student2, "b");
          treeMap.put(student3, "c");
          //返回元素个数
          System.out.println(treeMap.size());
          //返回元素集合
          System.out.println("返回元素集合：");
          System.out.println(treeMap);
          //删除元素
          treeMap.remove(student2);
          //删除所有
          //treeMap.clear();
          System.out.println("删除元素后：");
          System.out.println(treeMap);
          //遍历元素
          System.out.println("1.使用keySet");
          for (Student key : treeMap.keySet()) {
              System.out.println(key + "-" + treeMap.get(key));
          }
          System.out.println("\n2.使用entrySet");
          for (Map.Entry<Student, String> entry : treeMap.entrySet()) {
              System.out.println(entry.getKey() + "-" + entry.getValue());
          }
          System.out.println();
          //判断
          System.out.println(treeMap.containsKey(student2));
          System.out.println(treeMap.containsValue("a"));
          System.out.println(treeMap.isEmpty());
      }
  }
  ```

  

### 六、Colletions工具类

---

![image-20230116163644728](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230127131718768-20114001.png)



所有笔记来源于：[遇见狂神说 (bilibili.com)](https://space.bilibili.com/95256449)
