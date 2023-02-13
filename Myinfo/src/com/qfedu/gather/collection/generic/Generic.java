package com.qfedu.gather.collection.generic;

/**
 * @Author: XIYAN
 * @Date: 2023/1/14 14:32
 * @注释:泛型类(类名<T(占位符)>)
 */
public class Generic<T> {
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
}
