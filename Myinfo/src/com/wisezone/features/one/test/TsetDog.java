package com.wisezone.features.one.test;

import com.wisezone.features.one.Dog;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 11:31
 * @注释:
 */
public class TsetDog {
    /**
     * Junit 单元测试   没有返回值  无参方法
     * 运行时单独选中一个方法名后运行 ， 否则会运行全部的单元测试方法
     * 必须在方法头上加上@Test注解 ， 否则只是一个类里的普通方法
     */
    @Test
    public void test() {
        System.out.print("这是一个单元测试方法");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dog dog1 = new Dog("欧欧", "雪娜瑞");
        Dog dog2 = new Dog("亚亚", "拉布拉多");
        Dog dog3 = new Dog("菲菲", "拉布拉多");
        Dog dog4 = new Dog("美美", "雪娜瑞");
        Map map = new HashMap<>();
        map.put(dog1.getName(), dog1.getStrain());
        map.put(dog2.getName(), dog2.getStrain());
        map.put(dog3.getName(), dog3.getStrain());
        map.put(dog4.getName(), dog4.getStrain());
        System.out.print("请输入需要查找的狗狗姓名：");
        String name = input.next();
        if (map.containsKey(name)) {
            System.out.println("Map中存在指定对象，对象信息如下：");
            for (Object o : map.keySet()) {
                if (o.equals(name)) {
                    System.out.println(name + "\t\t" + map.get(o));
                }
            }
        } else {
            System.out.println("Map中不存在指定对象信息");
        }
    }

    @Test
    public void testGeneric() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }
}
