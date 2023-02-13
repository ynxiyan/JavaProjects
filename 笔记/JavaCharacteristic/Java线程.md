# [Java线程](https://www.cnblogs.com/ynxiyan/p/17076744.html)

从jdk1.0引入的Thread 类和Runable接口，以及到后来的jdk1.5版本引入的Callable 接口

### **一： 多线程原理**

进程就是操作系统对一个应用程序分配资源（比如：CPU，内存，磁盘、GPU，上下文环境等）的一个单位，而线程是在这个单元内进一步颗粒化的一个资源利用，比如说：我们启动QQ程序，那么系统就会给QQ程序分配各种资源，这个QQ程序我们就可以统称为一个进程。在QQ程序中，我们可以聊天，可以一对一聊天，也可以群聊，也可以下载文件等，但是我们这些操作都是在QQ这个程序（我们称之为进程）中执行了，在这里面的每一步操作，都是基于QQ进程的环境和上下文为依据的，这里每一个操作都被称为一个线程，那么他们是如何执行呢？比如说我同时和10个人聊天，那么这10个线程首先会放到一个线程池里，然后根据CPU执行的情况，去调用每一个线程。由于CPU执行的速度非常快，给我们感觉是一次行执行完毕，其实他内部是挨个去执行的。

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/55FD5815AA0A4CE9A3608257BAEDD35C/7838)

由于CPU执行的速度很快，给我们感觉是在一起执行，其实CPU内部的调度也是挨个去执行的。

### **二： 线程的五种状态**

对线程有了一个初步认识后，我们在大脑建立一个抽象的模型，可以构思一下，线程也是有生命周期的。

第一种：新建状态（**new**）：创建一个线程，但线程并未启动。线程没有执行run()、start()或者execute()方法。

 第二种：可运行状态（**runable**）：线程执行run()、start()或者execute（）方法，进入线程池等待被线程调度选中。

 第三种：阻塞状态（**blocked**）：当前线程在等待另一个线程的执行，比如等待一个synchronized修饰的方法或者块。

 第四种：等待状态（**waitting**）：处于这种状态的线程不会被CPU分配时间片。如果没有其他线程唤醒，将无限期等待下去

 第五种：有时间等待状态（**timed_waitting**）：处于这种状态的线程不会被CPU分配时间片，在指定的时间段内线程将被自动换醒。

 第六种：死亡状态（**terminated**）：线程结束后的一种状态。

 这六种状态都来自Enum Thread.State枚举类中，我们通过程序先来看第一种状态（new）：

```java
public class TestThread {
    public static void main(String[] args) {
        TestThread.testState();
    }
 
    public static void testState() {
        Thread th = new Thread();
        System.out.println(th.getState());
    }
}
```

这种状态就是线程通过new的方式刚被创建，没有调用run（）方法，可以称之为一个简单的线程壳。

第二状态是在线程执行run()或者start（）方法后，在java 虚拟机上的一种执行，他可能在等待来自操作系统的资源分配，比如等待获CPU时间片。

```java
 public static void main(String[] args) { 	//TestThread.testState(); 	WaitingThread waitingThread = new WaitingThread(); 	waitingThread.start(); 	System.out.println(waitingThread.getName()); 	System.out.println(Thread.currentThread().getName()); }  static class WaitingThread extends Thread { 	public void run() { 		while (true) { 			synchronized (WaitingThread.class) { 				try { 					WaitingThread.class.wait(); 				} catch (InterruptedException e) { 					e.printStackTrace(); 				} 			} 		} 	} }  public static void testState() { 	Thread th = new Thread(); 	System.out.println(th.getState()); } 
```

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/3F024DA4204D4D54B1FB7287E7B7CC47/7859)

运行后，我们获取俩个线程名称，一个main函数的主线程，一个WaitingThread 类的线程，我们在WaitingThread类线程中，让run()方法执行一个wait（）方法，这边main方法就会一直等待WaitingThread类执行完毕后，在执行主线程，此时我们通过Java mission control 控制台可以看到当前俩个线程的状态，main线程是一个runable状态，一直在等带分配资源，而WaitingThread线程是一个waiting状态，此时如果不手动终止程序执行，这俩个线程将一直保持该状态直到天长地久。

那么大家通过上面的示例，我们可以明白，通过调用wait（）方法，可以使线程进入waiting状态，其实线程进入waiting状态有三种方式：

 \1. 调用wait（）方法，没有设置时间，。

 \2. 调用join（）方法，在等待其他线程终止时。

 \3. 调用lockSupport.park（）方法。

下面我们通过示例演示调用join（）方法，使线程进行等待状态，第三种方式，不在这里演示，大家自行测试。

```java
public class WaitingThreadTwo extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
public class CallWaitingThread extends Thread {
    private WaitingThreadTwo wThreadTwo;
 
    public CallWaitingThread(WaitingThreadTwo wThreadTwo) {
        this.wThreadTwo = wThreadTwo;
    }
 
    @Override
    public void run() {
        try {
            wThreadTwo.join();
            for (int i = 10; i < 20; i++) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
public class TestTwoThread {
    public static void main(String[] args) {
        WaitingThreadTwo wThread = new WaitingThreadTwo();
        CallWaitingThread cwThread = new CallWaitingThread(wThread);
        wThread.start();
        cwThread.start();
    }
} 
```

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/3F026643DA4C43CDB754DE0A54BD153B/7863)

通过控制台输出我们可以看到。CallWaitingTHread线程 一直在等待WaitingThread 线程执行完毕后才输出：

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/C8140291587D406A9C9F7685EF6CCAF1/7870)

通过join()方法查看源码，里面也是调用wait()方法。

接下来我们time_waiting 状态，他是线程在指定的时间内等待，通过javaAPI我们可以看到，他有五种方法，可以让线程进行等待状态：

1. 调用sleep（time），指定时间。
2. 调用wait（time），指定时间。
3. 调用join（time），指定时间。
4. 调用lockSupport.parkNanos方法
5. 调用LockSupport.parkUntil方法

### **三：多线程三种实现方式**

多线程的实现有三种方式，从jdk1.0的Thread 类Runable 接口，到jdk1.5的Callable接口。下面我们通过详细的示例讲解三种实现方式。

#### **1. 继承Thread类**

通过继承Thread类实现，该类位于java.lang包下，他实现了Run able接口，有8个构造方法和若干个实现的方法

举例

创建一个线程，循环从0-10输出打印，并间隔2秒输出

我们是用的是用的java.util.concurrent.TimeUnit枚举类，该类下面有7个枚举常量，分别是

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/8F015F655272424E9ECA2DDD77B8EF61/7888)

通过该枚举常量然后调用sleep（）方法，可以给我们非常直观的时间概念，比如说我想让想让当前线程睡眠1秒，那么我们就可以TimeUnit.SECONDS.sleep(1)，是不是比Thread.sleep(1000) 看起来更加符合人类的语言呢？？

#### **2. 实现Runable接口**

第二种放方式是通过实现Runable接口创建线程，对于通过实现接口比继承的好处有很多，我就步一一在这里阐述， 但是在多线程中，通过实现接口实现多线程一个重要的优势是，线程池只接受接口。我们看一下jdkAPI的几个线程池提交方法：

[List](https://www.jianshu.com/java/util/List.html)<[Runnable](https://www.jianshu.com/java/lang/Runnable.html)>[shutdownNow](https://www.jianshu.com/java/util/concurrent/ExecutorService.html#shutdownNow--)()

Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.

[Future](https://www.jianshu.com/java/util/concurrent/Future.html)[submit](https://www.jianshu.com/java/util/concurrent/ExecutorService.html#submit-java.util.concurrent.Callable-)([Callable](https://www.jianshu.com/java/util/concurrent/Callable.html) task)

Submits a value-returning task for execution and returns a Future representing the pending results of the task.

[Future](https://www.jianshu.com/java/util/concurrent/Future.html)[submit](https://www.jianshu.com/java/util/concurrent/ExecutorService.html#submit-java.lang.Runnable-)([Runnable](https://www.jianshu.com/java/lang/Runnable.html)task)

Submits a Runnable task for execution and returns a Future representing that task.

[Future](https://www.jianshu.com/java/util/concurrent/Future.html)[submit](https://www.jianshu.com/java/util/concurrent/ExecutorService.html#submit-java.lang.Runnable-T-)([Runnable](https://www.jianshu.com/java/lang/Runnable.html)task, T result)

Submits a Runnable task for execution and returns a Future representing that task.

他都是只接收接口，其中就是Runable 和Callable接口。当然了，类也不是说一无是处，他有自己的优点，比如说类中start（）方法，就是一个异步启动执行线程的，后面我们在区别和联系中会详细讲解到。

举例：实现Runable接口并调用进程方法启动打印输出

通过控制台，我们可以看到输出的详细信息，如果大家仔细查看的话，发现是按顺序先执行线程1，然后在执行线程2，这个就是run（）执行的步骤

#### **3. 实现Callable接口**

 Callable接口的出现是为了满足线程执行完毕后返回结果而出现的，我们都知道，通过实现Runable接口和继承Thread类运行run（）方法后， 该类是没有返回值的，假设我对一个班级的学生成绩统计后返回一个list，那么我就没法通过run（）方法去实现，我只能通过一个类的全局变量，然后在run（）方式里面复制去实现，如果一个线程没有问题，线程多的话，就涉及到一个变量共享问题，导致我存的数据可能不是我想要的。那么Callable就能解决该问题

```java
public class CallWaitingThread extends Thread {
    private WaitingThreadTwo wThreadTwo;
 
    public CallWaitingThread(WaitingThreadTwo wThreadTwo) {
        this.wThreadTwo = wThreadTwo;
    }
 
    @Override
    public void run() {
        try {
            wThreadTwo.join();
            for (int i = 10; i < 20; i++) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}              
 
import java.util.ArrayList;import java.util.List;import java.util.concurrent.Callable;
 
public class CallableTest implements Callable {
    private List list;
 
    public CallableTest(List list) {
        this.list = list;
    }
 
    @Override
    public List call() throws Exception {
        List lists = new ArrayList();
        list.forEach(e -> {
            lists.add(e.toString().toCharArray()[0]);
        });
        return lists;
    }
}
```

通过上述例子我们可以看到，通过实现Callable 接口，调用他对于的call方法可以返回具体执行的对象，在本例程序中，我们处理一个人员名称对象列表，然后获取姓氏，可以通过统计该列表中每个姓氏人员有多少个，通过call（）方法实现后，我们将处理的lists返回，通过控制台打印后，我们可以看到返回的结果：

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/8724A4F6EC5C4CC4BEF9B14C55FA31DA/7898)

#### **4. 三种方式区别和内在联系**

 通过上面的示例，我们基本了解了三种线程的实现方式，也对三种实现方式有了最基本认识，那么下面我们就一起来看看他们的区别和联系：

 \1. Thread类是一个实现了Runable接口的类，他有三个静态变量可以设置线程的优先级,[MAX_PRIORITY](https://www.jianshu.com/java/lang/Thread.html#MAX_PRIORITY)，[MIN_PRIORITY](https://www.jianshu.com/java/lang/Thread.html#MIN_PRIORITY)，[NORM_PRIORITY](https://www.jianshu.com/java/lang/Thread.html#NORM_PRIORITY)，如果我们有这个设置线程优先级的需求，我们就的需要通过继承Thread类。

 \2. Thread类有个一个start（）方法，他是可以做的多线程异步执行，通过上面的示例，我们可以很明确的了解到，start（）方式执行后，线程并不是按照顺序执行的。

 \3. Runable是一个接口，最后的好处是接口可以多实现，而类是个单继承，其次，如果我们在实际业务中用到线程池时，那么我们就的使用Runable或则Callable接口了，上面我们也讲到线程池只接受接口参数。

 \4. Callable也是一个接口，他可以接受一个泛型，是为了返回值做准备的，通过上面的示例我们也可以看到，Callable最大最好用的是call（）方法可以返回你想要的任何数据。

\5. 关于线程优先级这块，在这里不做详细讲解，在实际业务的涉及到线程优先级的很少，而且如果控制不当，很容易造成严重的后果。

#### **5. 在看线程的状态转换**

上面我们详细了介绍了线程的几种状态，并且通过各种示例对线程的状态进行详细的展示，下面我们总结一下线程之间这几种状态的转换。大家可以结合上面示例和本图进行一个详细的理解，这样有助于对线程状态的进一步深入了解。

![0](https://note.youdao.com/yws/public/resource/1bd62f4cd67a7b69b4befbd3514f0ed8/xmlnote/EC471B37AE2D4F1D9CB43AF2AD1075FB/7905)

#### **6. 从源码总结run()、start()和Call（）方法区别**

在start（）方法源码中，调用了一个start0（）方法，我们可以看到start0（）方法是通过private native void start0() native进行修饰的，该方法是一个原生态的方法，方法的实现不在当前文件中。

run（）方法其实他是当作一个普通的方法执行的，他必须等run（）方法体内程序逻辑执行完毕后，才会执行后续的代码，而start（）方法是真是意义上的多线程，他的执行不会去等待run（）方法体内的逻辑

实际上通过start（）方法后，他马上把该线程状态设置为可运行状态，放入等待队列，然后执行下个操作，他不会等run（）方法体的具体执行情况，通过控制台我们可以看到，他的输出不是有序的，start（）方法可以说才是真正的多线程模式。

在看run（）方法执行过程，run（）方法是按顺序执行的，只有第一个线程执行完毕后，才会执行第二个线程，不管你执行多少次都是有序的输出，和start（）方法不同，start（）方法我们可以多次尝试发现，每次执行输出的结果都会不一样。

接下来我们看call（）方法，该方法是Callable接口中唯一的一个方法，返回一个Object对象，如果我们通过实现Callable接口然后调用call（）方法，发现他出和run（）方法有点类似，除了他能返回结果外。其中都是在main主线程中执行的，并且执行的过程中都是有顺序的。

**扩展学习**

### **四：线程池技术（需要用到Executor框架）**