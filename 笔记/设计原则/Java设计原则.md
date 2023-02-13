# [Java设计原则](https://www.cnblogs.com/ynxiyan/p/17094948.html)

在软件开发中，为了提高软件系统的可维护性和可复用性，增加软件的可扩展性和灵活性，程序员要尽量根据6条原则来开发程序，从而提高软件开发效率、节约软件开发成本和维护成本。



### 一、 开闭原则

---

**对扩展开放，对修改关闭**。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。

想要达到这样的效果，我们需要使用接口和抽象类。

因为抽象灵活性好，适应性广，只要抽象的合理，可以基本保持软件架构的稳定。而软件中易变的细节可以从抽象派生来的实现类来进行扩展，当软件需要发生变化时，只需要根据需求重新派生一个实现类来扩展就可以了。

【例】`搜狗输入法` 的皮肤设计。

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206115640016-1014675201.png)

**抽象皮肤类（AbstractSkin）：**

```java
public abstract class AbstractSkin {
    //显示方法
    public abstract void display();
}
```

**默认皮肤（DefaultSkin）：**

```java
public class DefaultSkin extends AbstractSkin {
    /**
     *
     */
    @Override
    public void display() {
        System.out.println("默认皮肤");
    }
}
```

**自定义皮肤皮肤（CustSkin）：**

```java
public class CustSkin extends AbstractSkin {
    /**
     *
     */
    @Override
    public void display() {
        System.out.println("自定义皮肤");
    }
}
```

**搜狗输入法（SouGouInput）：**

```java
public class SouGouInput {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
```

**测试：**

```java
public class TestSkin {
    public static void main(String[] args) {
        //使用皮肤
        SouGouInput souGouInput=new SouGouInput();
        //用户选择皮肤
        DefaultSkin defaultSkin=new DefaultSkin();
        CustSkin custSkin =new CustSkin();
        //调用
        souGouInput.setSkin(defaultSkin);
        //显示
        souGouInput.display();
    }
}
```



### 二、里氏代换原则

---

里氏代换原则是面向对象设计的基本原则之一。

里氏代换原则：**任何基类可以出现的地方，子类一定可以出现。通俗理解：子类可以扩展父类的功能，但不能改变父类原有的功能。**换句话说，子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。

如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的可复用性会比较差，特别是运用多态比较频繁时，程序运行出错的概率会非常大。

下面看一个里氏替换原则中经典的一个例子

【例】正方形不是长方形。

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206115639682-301533019.png)

我们发现，假如我们把一个普通长方形作为参数传入resize方法，就会看到长方形宽度逐渐增长的效果，当宽度大于长度,代码就会停止，这种行为的结果符合我们的预期；假如我们再把一个正方形作为参数传入resize方法后，就会看到正方形的宽度和长度都在不断增长，代码会一直运行下去，直至系统产生溢出错误。所以，普通的长方形是适合这段代码的，正方形不适合。
我们得出结论：在resize方法中，Rectangle类型的参数是不能被Square类型的参数所代替，如果进行了替换就得不到预期结果。因此，Square类和Rectangle类之间的继承关系违反了里氏代换原则，它们之间的继承关系不成立，正方形不是长方形。

如何改进呢？此时我们需要重新设计他们之间的关系。抽象出来一个四边形接口(Quadrilateral)，让Rectangle类和Square类实现Quadrilateral接口

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122526541-381275034.png)

代码如下：

**四边形接口（Quadrilateral）：**

```java
public interface Quadrilateral {
    //获取长
    double getLength();

    //获取宽
    double getWidth();
}
```

**长方形类（Rectangle）：**

```java
public class Rectangle implements Quadrilateral{
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return
     */
    @Override
    public double getLength() {
        return length;
    }

    /**
     * @return
     */
    @Override
    public double getWidth() {
        return width;
    }
}
```

**正方形（Square）：**

由于正方形的长和宽相同，所以在方法setLength和setWidth中，对长度和宽度都需要赋相同值。

```java
public class Square implements Quadrilateral{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    /**
     * @return
     */
    @Override
    public double getLength() {
        return side;
    }

    /**
     * @return
     */
    @Override
    public double getWidth() {
        return side;
    }
}
```

**测试：**

```java
public class Test {
    public static void main(String[] args) {
        //创建长方形
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        //调用扩宽
        resize(rectangle);
        //打印
        print(rectangle);
        //创建正方形
        Square square=new Square();
        //只能调用自己
        square.setSide(12);
    }

    /**
     * 扩宽
     *
     * @param rectangle
     */
    public static void resize(Rectangle rectangle) {
        while (rectangle.getLength() >= rectangle.getWidth()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    /**
     * 打印
     *
     * @param quadrilateral
     */
    public static void print(Quadrilateral quadrilateral) {
        System.out.println(quadrilateral.getLength() + "\t" + quadrilateral.getWidth());
    }
}

```



### 三、依赖倒转原则

---

**高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象。**简单的说就是要求对抽象进行编程，不要对实现进行编程，这样就降低了客户与实现模块间的耦合。

下面看一个例子来理解依赖倒转原则

【例】组装电脑

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122526211-1075131635.png)

但是似乎组装的电脑的cpu只能是Intel的，内存条只能是金士顿的，硬盘只能是希捷的，这对用户肯定是不友好的，用户有了机箱肯定是想按照自己的喜好，选择自己喜欢的配件。

根据依赖倒转原则进行改进：

代码我们只需要修改Computer类，让Computer类依赖抽象（各个配件的接口），而不是依赖于各个组件具体的实现类。

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122525830-68942113.png)

代码如下：

**硬盘接口（HardDisk）：**

```java
public interface HardDisk {
    /**
     * 存储数据
     */
    void save(String data);

    /**
     * 获取数据
     *
     * @return
     */
    String get();
}

```

**希捷硬盘类（XJDisk）:**

```java
public class XJDisk implements HardDisk {
    /**
     * 存储数据
     */
    @Override
    public void save(String data) {
        System.out.println("存储的数据为" + data);
    }

    /**
     * 获取数据
     *
     * @return
     */
    @Override
    public String get() {
        return "数据";
    }
}

```

**CPU接口（Cpu）：**

```java
public interface Cpu {
    /**
     * 运行
     */
    void run();
}
```

**Intel处理器（Intel）：**

```java
public class Intel implements Cpu{
    /**
     * 运行
     */
    @Override
    public void run() {
        System.out.println("使用Intel");
    }
}
```

**内存条接口（Memory）：**

```java
public interface Memory {
    /**
     * 存储数据
     */
    void save();

    /**
     * 获取数据
     * @return
     */
    String get();
}
```

**金士顿内存条（King）：**

```java
public class King implements Memory{
    /**
     * 存储数据
     *
     */
    @Override
    public void save() {
        System.out.println("存储的数据为");
    }

    /**
     * 获取数据
     *
     * @return
     */
    @Override
    public String get() {
        return "数据";
    }
}
```

**电脑（Computer）：**

```java
public class Computer {
    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    /**
     * 运行
     */
    public void run() {
        System.out.println("运行计算机");
        String data = hardDisk.get();
        cpu.run();
        memory.save();
    }
}
```

**测试：**

```java
public class Test {
    public static void main(String[] args) {
        //创建组件
        HardDisk disk = new XJDisk();
        Cpu cpu = new Intel();
        Memory memory = new King();
        //创建计算机
        Computer computer = new Computer();
        //组装
        computer.setHardDisk(disk);
        computer.setCpu(cpu);
        computer.setMemory(memory);
        //运行
        computer.run();
    }
}

```

面向对象的开发很好的解决了这个问题，一般情况下抽象的变化概率很小，让用户程序依赖于抽象，实现的细节也依赖于抽象。即使实现细节不断变动，只要抽象不变，客户程序就不需要变化。这大大降低了客户程序与实现细节的耦合度。



### 四、接口隔离原则

---

**客户端不应该被迫依赖于它不使用的方法；一个类对另一个类的依赖应该建立在最小的接口上。**

下面看一个例子来理解接口隔离原则

【例】安全门案例

我们需要创建一个安全门，该安全门具有防火、防水、防盗的功能。可以将防火，防水，防盗功能提取成一个接口，形成一套规范。类图如下：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206115639371-1462076037.png)

上面的设计我们发现了它存在的问题，安全门具有防盗，防水，防火的功能。现在如果我们还需要再创建一个传智品牌的安全门，而该安全门只具有防盗、防水功能呢？很显然如果实现SafetyDoor接口就违背了接口隔离原则，那么我们如何进行修改呢？看如下类图：

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206115638895-1618025172.png)

代码如下：

**防盗接口（AntiTher）：**

```java
public interface AntiTher {
    /**
     * 防盗
     */
    void antiTher();
}
```

**防火接口（Fireproof）：**

```java
public interface Fireproof {
    /**
     * 防火
     */
    void fireProof();
}
```

**防水接口（Waterproof）：**

```java
public interface Waterproof {
    /**
     * 防水
     */
    void waterProof();
}
```

**门（Door）：**

```java
public class Door implements AntiTher,Fireproof,Waterproof{
    /**
     * 防盗
     */
    @Override
    public void antiTher() {
        System.out.println("防盗功能");
    }

    /**
     * 防火
     */
    @Override
    public void fireProof() {
        System.out.println("防火功能");
    }

    /**
     * 防水
     */
    @Override
    public void waterProof() {
        System.out.println("防水功能");
    }
}
```



### 五、迪米特法则

---

迪米特法则又叫最少知识原则。

只和你的直接朋友交谈，不跟“陌生人”说话（Talk only to your immediate friends and not to strangers）。

其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。

迪米特法则中的“朋友”是指：**当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等，这些对象同当前对象存在关联、聚合或组合关系，可以直接访问这些对象的方法。**

下面看一个例子来理解迪米特法则

【例】明星与经纪人的关系实例

明星由于全身心投入艺术，所以许多日常事务由经纪人负责处理，如和粉丝的见面会，和媒体公司的业务洽淡等。这里的经纪人是明星的朋友，而粉丝和媒体公司是陌生人，所以适合使用迪米特法则。

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122525522-1016126147.png)

代码如下：

**明星（Star）：**

```java
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

**粉丝（Fans）：**

```java
public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

**公司（Company）：**

```java
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

**经纪人（Agent）：**

```java
public class Agent {
    //聚合
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * 和粉丝见面
     */
    public void meetIng() {
        System.out.println(star.getName() + "和粉丝" + fans.getName() + "见面");
    }

    /**
     * 和公司洽谈业务
     */
    public void business() {
        System.out.println(star.getName() + "和" + company.getName() + "洽谈业务");
    }
}
```

**测试：**

```java
public class Test {
    public static void main(String[] args) {
        //创建经纪人
        Agent agent = new Agent();
        //创建明星
        Star star = new Star("张三");
        agent.setStar(star);
        //创建粉丝
        Fans fans = new Fans("李四");
        agent.setFans(fans);
        //创建公司
        Company company = new Company("XX公司");
        agent.setCompany(company);
        //和粉丝见面
        agent.meetIng();
        //和公司洽谈业务
        agent.business();
    }
}
```



### 六、合成复用原则

---

合成复用原则是指：**尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。**

通常类的复用分为继承复用和合成复用两种。

继承复用虽然有简单和易实现的优点，但它也存在以下缺点：

```markdown
- 1.继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类是透明的，所以这种复用又称为“白箱”复用。
- 2.子类与父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，这不利于类的扩展与维护。
- 3.它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化。
```


采用组合或聚合复用时，可以将已有对象纳入新对象中，使之成为新对象的一部分，新对象可以调用已有对象的功能，它有以下优点：

```markdown
- 1.它维持了类的封装性。因为成分对象的内部细节是新对象看不见的，所以这种复用又称为“黑箱”复用。
- 2.对象间的耦合度低。可以在类的成员位置声明抽象。
- 3.复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态地引用与成分对象类型相同的对象。
```

下面看一个例子来理解合成复用原则

【例】汽车分类管理程序

汽车按“动力源”划分可分为汽油汽车、电动汽车等；按“颜色”划分可分为白色汽车、黑色汽车和红色汽车等。如果同时考虑这两种分类，其组合就很多。类图如下： 

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122525105-1238401716.png)

从上面类图我们可以看到使用继承复用产生了很多子类，如果现在又有新的动力源或者新的颜色的话，就需要再定义新的类。我们试着将继承复用改为聚合复用看一下。

![](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230206122524411-1921805292.png)

**车（Car）：**

```java
public class Car {
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void move(){
        System.out.println("车");
    }
}
```

**颜色接口（Color）：**

```java
public interface Color {
}

```

**车漆（Paint）：**

```java
public class Paint implements Color {
    String color;

    public Paint(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Red{" +
                "color='" + color + '\'' +
                '}';
    }
}
```

**燃油车（Petrol）：**

```java
public class Petrol extends Car {
    @Override
    public void move(){
        System.out.println("燃油车");
    }
}
```

**电动车（Electrle）：**

```java
public class Electrle extends Car {
    @Override
    public void move() {
        System.out.println("电动车");
    }
}
```

**测试：**

```java
public class Test {
    public static void main(String[] args) {
        //车漆
        Paint paint = new Paint("红");
        //创建燃油车
        Car pCar = new Petrol();
        //创建电动车
        Car eCar = new Electrle();
        pCar.move();
        //喷漆
        pCar.setColor(paint);
        System.out.println(pCar.getColor());
    }
}
```



所有笔记来源于：[黑马程序员 (bilibili.com)](https://space.bilibili.com/37974444)
