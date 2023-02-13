package com.qfedu.gather.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: XIYAN
 * @Date: 2023/1/13 18:22
 * @注释:使用Scanner从控制台读取一个字符串，统计字符串中每个字符出现的次数，要求使用学习过的知识完成以上要求 实现思路根据Set、List、Map集合的特性完成。
 */
public class Each {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = input.next();
        //将字符串转换为字符数组
        char[] character = str.toCharArray();
        //创建Map集合对象
        Map map = new HashMap<>();
        //增强for遍历
        for (char c : character) {
            //检查key为c是否存在
            if (map.containsKey(c)) {
                //获取指定键所映射的值
                Integer num = (Integer) map.get(c);
                //计数
                num++;
                //添加对象
                map.put(c, num);
            } else {
                map.put(c, 1);
            }
        }
        //获取map所有的key
        Set set = map.keySet();
        //增强for
        for (Object o : set) {
            System.out.print(o + ",出现了" + map.get(o) + "次\t");
        }

    }
}
