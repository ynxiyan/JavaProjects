# [java基础](https://www.cnblogs.com/ynxiyan/p/17030784.html)

#### Java规范

------

![image-20221208151817285](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160604401-609238599.png)

#### Java 的编译过程

------

- **记事本写java 的步骤**

```java
public class 类名 {
public static void main(String[ ] args){
System.out.println("Hello,World");
 
	}
}
```

1. 编写源代码 ： 保存成 类名.ava 保存文件编码默认ANSI格式可以显示中文
2. 首字母大写
   第二个首字母也要大写
   2 ． 编译源文件 ： 把编写好的源文件通过javac 命令编译成 类名 .class 字节码文件 （ 二进制文件 ）
   3 ． 运行编译后的class文件 ：java 命令运行 类名

![image-20221208140206560](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160603955-940284513.png)

程序的三大结构： 顺序结构 、 选择结构 、循环结构
编写程序步骤：编写源程序 、编译源代码 、 运行编译后的代码
.class 字节码文件（ 二进制 ）
IDE（ 集成开发环境 ）
记事本 DOS 命令 ： javac 编译命令 java 命令运行.class 文件
Java 注释：单行注释// 多行注释 /* 开头 */ 结尾 javaDOC 注释 /** */
顺序结构：代码是一行一行执行 ，有一个单等号（ 赋值运算符 ）时执行顺序是从右到左

```markdown
Java 历史 ： 最先叫 Oak （ 橡树的英文 ） ， 1995 年 sun 公司推出 Java ，sun 公司 2009 年被 Oracle （ 甲骨文 ） 公司收购 ， Java 之父詹姆斯高斯林
Java 技术平台 ：
Java SE ： 标准版基础版
Java EE ： 企业版 java web
Java ME ： 移动端 Android 端嵌入端开发如 POS 机等
2.对象 （ 引用数据 ） 类型null
```

### 一、基础

#### 1.标识符

------

- **关键字**

  ![java关键字](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160603552-1376331903.png)

- **标识符注意点**

  ![标识符注意点](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160603099-49332068.png)

#### 2.数据类型

------

![数据类型](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160602617-1526780055.png)

- **八大基本类型**

  1.成员变量

  ![八大基本类型](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160602159-252207724.png)

  2.成员变量 （ 属性 ） 的默认值

  ```java
  byte 0
  short 0
  int 0
  long 0
  float 0.0
  double 0.0
  boolean false
  char ' \ u000' ' '
  ```

  3.2-3-2-1

  - 二个字符型

    byte字节型（0，1）

    char字符型 单个字符(支持ASCIII码、UNICODE码)

  - 三个整型

    short短整型

    int整型

    long长整型

  - 二个浮点型

    float单精度浮点型

    double双精度浮点型

  - 一个布尔型

    boolean 值 true/false 真/假

  除了八个基本数据类型 ， 其它的类型都叫做引用 （ 对象 ） 类型

- **拓展**

  ![整数拓展](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160601751-1478722396.png)

  ![浮点数拓展](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160601327-474140480.png)

  ![字符拓展](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160600903-1227240734.png)

  ![布尔值拓展](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160600447-465051149.png)

#### 3.类型转换

------

![类型转换](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160600073-1569404035.png)

![转换](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160559664-1670542191.png)

![注意点](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160559329-695473183.png)

#### 4.变量

在 JAVA 里 ， 看见首字母大写的就是类或（ 接囗 、 枚举 ）
看见单引号括起来的就是char类型 ，双引号括起来的就是字符串 ，看见全大写的就是常量 ，中括号括起来的是数组 ，小括号就是方法 ， 里面有参数就是带参方法 ，没参就是无参方法 ，大括号括起来的就叫代码块 ，尖括号括起来的叫泛型

数字中使用下划线
规则 1 ：JDK1.7 或以上
规则 2 ：只能用在数字之间 ，不能用在数字开头或结尾 ，
小数点前后也不行

------

![变量](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160558924-1130640309.png)

#### 5.变量作用域

------

![变量作用域](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160558512-785589759.png)

![实例变量](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160558117-311451114.png)

![局部变量](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160557754-1660220021.png)

#### 6.常量

------

![常量](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160557413-2075645967.png)

#### 7.Java的命名规范

------

![Java命名规范1](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160557024-827388415.png)
![Java命名规范2](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160556491-139789459.png)

#### 8.转义符

![image-20221208150958593](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160555985-1668927552.png)

#### 9.运算符

------

![运算符](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160555589-446453173.png)

- **位运算符**

  ![位运算符](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160555165-1030433157.png)

- **逻辑运算符**

  ![image-20221209102707722](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160554796-43033127.png)

- ![image-20221209094352468](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160554329-1948302843.png)

  ![image-20221209094426974](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160553891-123657144.png)

#### 10.Java Math 类

Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。

Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。

------

- **Number & Math 类方法**

  下面的表中列出的是 Number & Math 类常用的一些方法：

  | 序号 | 方法与描述                                                   |
  | :--- | :----------------------------------------------------------- |
  | 1    | [xxxValue()](https://www.runoob.com/java/number-xxxvalue.html) 将 Number 对象转换为xxx数据类型的值并返回。 |
  | 2    | [compareTo()](https://www.runoob.com/java/number-compareto.html) 将number对象与参数比较。 |
  | 3    | [equals()](https://www.runoob.com/java/number-equals.html) 判断number对象是否与参数相等。 |
  | 4    | [valueOf()](https://www.runoob.com/java/number-valueof.html) 返回一个 Number 对象指定的内置数据类型 |
  | 5    | [toString()](https://www.runoob.com/java/number-tostring.html) 以字符串形式返回值。 |
  | 6    | [parseInt()](https://www.runoob.com/java/number-parseInt.html) 将字符串解析为int类型。 |
  | 7    | [abs()](https://www.runoob.com/java/number-abs.html) 返回参数的绝对值。 |
  | 8    | [ceil()](https://www.runoob.com/java/number-ceil.html) 返回大于等于( >= )给定参数的的最小整数，类型为双精度浮点型。 |
  | 9    | [floor()](https://www.runoob.com/java/number-floor.html) 返回小于等于（<=）给定参数的最大整数 。 |
  | 10   | [rint()](https://www.runoob.com/java/number-rint.html) 返回与参数最接近的整数。返回类型为double。 |
  | 11   | [round()](https://www.runoob.com/java/number-round.html) 它表示**四舍五入**，算法为 **Math.floor(x+0.5)**，即将原来的数字加上 0.5 后再向下取整，所以，Math.round(11.5) 的结果为12，Math.round(-11.5) 的结果为-11。 |
  | 12   | [min()](https://www.runoob.com/java/number-min.html) 返回两个参数中的最小值。 |
  | 13   | [max()](https://www.runoob.com/java/number-max.html) 返回两个参数中的最大值。 |
  | 14   | [exp()](https://www.runoob.com/java/number-exp.html) 返回自然数底数e的参数次方。 |
  | 15   | [log()](https://www.runoob.com/java/number-log.html) 返回参数的自然数底数的对数值。 |
  | 16   | [pow()](https://www.runoob.com/java/number-pow.html) 返回第一个参数的第二个参数次方。 |
  | 17   | [sqrt()](https://www.runoob.com/java/number-sqrt.html) 求参数的算术平方根。 |
  | 18   | [sin()](https://www.runoob.com/java/number-sin.html) 求指定double类型参数的正弦值。 |
  | 19   | [cos()](https://www.runoob.com/java/number-cos.html) 求指定double类型参数的余弦值。 |
  | 20   | [tan()](https://www.runoob.com/java/number-tan.html) 求指定double类型参数的正切值。 |
  | 21   | [asin()](https://www.runoob.com/java/number-asin.html) 求指定double类型参数的反正弦值。 |
  | 22   | [acos()](https://www.runoob.com/java/number-acos.html) 求指定double类型参数的反余弦值。 |
  | 23   | [atan()](https://www.runoob.com/java/number-atan.html) 求指定double类型参数的反正切值。 |
  | 24   | [atan2()](https://www.runoob.com/java/number-atan2.html) 将笛卡尔坐标转换为极坐标，并返回极坐标的角度值。 |
  | 25   | [toDegrees()](https://www.runoob.com/java/number-todegrees.html) 将参数转化为角度。 |
  | 26   | [toRadians()](https://www.runoob.com/java/number-toradians.html) 将角度转换为弧度。 |
  | 27   | [random()](https://www.runoob.com/java/number-random.html) 返回一个随机数。 |

#### 11.包机制

------

![包](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160553500-198124174.png)

#### 12.JavaDoc

------

![JavaDoc](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160553051-164298764.png)

### 二、流程控制

#### 1.Scanner对象

------

![image-20230104171207670](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160552571-1681730624.png)

![image-20230104171642363](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160552090-1141136711.png)

#### 2.顺序结构

------

![image-20230104173643362](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160551640-1304867373.png)

#### 3.选择结构

------

- **if单选择结构**

  ![image-20230104174636738](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160551219-1408889868.png)

- **if双选择结构**

  ![image-20230104174736381](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160550758-703009048.png)

- **if多选择结构**

  ![image-20230104175255930](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160550253-536048623.png)

- **嵌套的if结构**

  ![image-20230104175801458](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160549752-808467835.png)

- **switch多选择结构**

  ![image-20230104181011164](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160549272-1733721917.png)

#### 4.循环结构

------

- **while循环**

  ![image-20230104181540055](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160548738-1851643119.png)

- **do while循环**

  ![image-20230104181728962](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160548244-838288275.png)

- **for循环**

  ![image-20230104181847817](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160547797-663676524.png)

  ![image-20230104182218744](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160547396-1713265316.png)

- **增强型for循环**

  ![image-20230104182806759](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160547013-760609962.png)

- **foreach**

  ```markdown
  for的简化形式,与for的区别仅仅是隐藏了循环条件,不需要使用下标,适合在不关心下标,需要把数组或集合全部遍历的情况 0dk1.5 或以上 ）
  foreach迭代不会数组越界,适合循环输出所有的元素
  foreach会默认全部输出数组或列表对象
  迭代对象可以是数组或集合
  for（ 数据类型   迭代元素（ 元素名or对象名 ） ：迭代对象（ 数组或集合 ）） {}
  ```

- **break&continue&goto**

  ![image-20230104183306967](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160546528-892290287.png)

### 三、方法

#### 1.什么是方法

------

![image-20230105132307402](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160546045-1132441782.png)

#### 2.方法的定义

------

![image-20230105133237980](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160545569-1725369368.png)

#### 3.方法调用

------

![image-20230105134604798](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160545013-345376058.png)

#### 4.方法重载

------

![image-20230105135050866](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160544590-1914353181.png)

#### 5.命令行传参

------

![image-20230105140309299](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160543606-1489727374.png)

#### 6.可变参数

------

![image-20230105140924319](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160543134-1919771727.png)

#### 7.递归

------

![image-20230105142411320](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160542551-1692317684.png)

- **示例**

  ```java
  public static void main(String[] args) {
      //递归（小计算可用，大计算禁用！！！），求阶乘（2！=2*1 3！=3*2*1）
      System.out.println(factorial(5));
  }
   
  /**
   * 求阶乘
   *
   * @param num
   * @return
   */
  public static int factorial(int num) {
      if (num == 1) {
          return num;
      } else {
          return num * factorial(num - 1);
      }
  }
  ```

- **原理**

  ![image-20230105145252853](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160542202-644973601.png)

### 四、数组

#### 1.数组的定义

------

![image-20230106125829062](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160541844-1325557539.png)

#### 2.数组声明创建

------

![image-20230106130028399](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160541465-27114024.png)

#### 3.内存分析

------

![image-20230106131048092](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160541099-620049527.png)

![image-20230106132014020](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160540729-1416428750.png)

#### 3.三种初始化

------

![image-20230106132043396](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160540383-615394674.png)

#### 4.数组的四个基本特点

------

![image-20230106132657287](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160539937-1706644556.png)

#### 5.数组边界

------

![image-20230106132946193](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160539524-1324356405.png)

#### 6.数组的使用

------

![image-20230106134226852](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160538943-1242941119.png)

### 五、多维数组

![image-20230106134355215](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160538576-962838886.png)

- **数组结构**

  ![image-20230106134719017](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160538258-1445700463.png)

#### 1.二维数组

------

![image-20230106134456311](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160537918-1218690394.png)

- **二维数组结构**

  ![image-20230106135056422](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160537591-472065234.png)

### 六、Arrays类

![image-20230106135422007](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160537146-342639451.png)

### 七、冒泡排序

![image-20230106140646250](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160536548-1958428606.png)

![image-20230106141216100](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160536169-267509647.png)

![image-20230106141245822](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160535804-103082410.png)

![image-20230106140705306](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160535410-1287604851.png)

- **原理**

  交换前：![image-20230106140758789](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160534989-2084999095.png)

  交换后：

  ![image-20230106140838217](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160534545-1674671471.png)

- **优化**

  ![image-20230106141548315](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160533960-1855370545.png)

### 八、稀疏数组

#### 1.稀疏数组介绍

------

![image-20230106141909441](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160533535-1453471447.png)

![image-20230106141814724](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230106160532971-1992084040.png)

```java
//1. 创建一个二维数组 11*11
    // 0：没有棋子（数组默认值）
    // 1：黑子
    // 2：白子
    static String chessman = "0";
 
    public static void main(String[] args) {
        int[][] chess = new int[11][11]; //棋盘数据
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[6][6] = 2;
        chess[9][9] = 1;
        chess[8][5] = 1;
        chess[4][10] = 2;
        System.out.println("棋盘：");
        print(chess);
        //保存棋盘数据成稀疏数组
        int valid = 0; //棋子数
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    valid++;
                }
            }
        }
        int[][] sparseArray = new int[valid + 1][3]; //稀疏数组
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = valid;
        int value = 0; //棋子坐标
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    value++;
                    sparseArray[value][0] = i;
                    sparseArray[value][1] = j;
                    sparseArray[value][2] = chess[i][j];
                }
            }
        }
        System.out.println("棋盘数据：");
        System.out.println("\t\t行\t列\t值\\棋子");
        for (int i = 0; i < sparseArray.length; i++) {
            if (i == 0) {
                System.out.println("棋盘总览：" + sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
            } else {
                if (sparseArray[i][2] == 1) {
                    chessman = "黑";
                }
                if (sparseArray[i][2] == 2) {
                    chessman = "白";
                }
                System.out.println("\t\t" + (sparseArray[i][0] + 1) + "\t" + (sparseArray[i][1] + 1) + "\t" + chessman);
                chessman = "0";
            }
        }
        //还原
        int[][] restore = new int[sparseArray[0][0]][sparseArray[0][1]];  //还原数据组
        for (int i = 1; i < sparseArray.length; i++) {
            restore[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("棋盘还原：");
        print(restore);
    }
 
    /**
     * 棋盘输出
     *
     * @param array
     */
    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    chessman = "黑";
                }
                if (array[i][j] == 2) {
                    chessman = "白";
                }
                System.out.print(chessman + "\t");
                chessman = "0";
            }
            System.out.println();
        }
```
