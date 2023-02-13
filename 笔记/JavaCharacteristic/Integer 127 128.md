# [Integer 127 128](https://www.cnblogs.com/ynxiyan/p/17076741.html)

![0](https://note.youdao.com/yws/public/resource/e486870684087b1e7c113a54a3de3278/xmlnote/4429939AFFEF42948439AAF0B3462581/10004)

```java
public class TestInteger {
    public static void main(String[] args) {
        // 1.127--127范围内正确 	
        Integer one = 127;
        Integer two = 127;
        System.out.println(one.equals(two));
        // 2.128范围内==内存地址不相等
        Integer three = 128;
        Integer four = 128;
        System.out.println(three.equals(four));
        System.out.println(three.intValue() == four.intValue());
    }
}
```

在Integer类装载入内存时，把[-128, 127]范围内的整型数据装包成Integer类，并将其对应的引用放入到cache数组中。

从上面的源码可以看出，valueOf()在返回之前，会进行判断，判断当前 i的值是否在 -128到127之间。

如果存在，则直接返回引用，不再重新开辟内存空间。

如果不存在，就创建一个新的对象。

利用缓存，这样做既能提高程序执行效率，还能节约内存。

Integer a1= 127; Integer a2 = 127; 因为 IntegerCache中已经存在此对象，直接返回引用，引用相等并且都指向缓存中的数据，所以这时候a1 == a2返回true。

Integer a1 = 128; Integer a2 = 128;因为a1，a2的值大于127，不在[-128, 127]范围内，所以虚拟机会在堆中重新new一个 Integer对象来存放128，创建两个对象就会产生两个这样的空间。两个空间的地址不同，返回到栈中的引用的值也就不同，所以这时候a1 == a2返回false。