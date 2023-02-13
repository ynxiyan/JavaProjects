package com.wisezone.features.one.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 10:55
 * @注释:
 */
public class TestMap {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        map.put("CN", "中华人民共和国");
        map.put("US", "美利坚合众国");
        map.put("RU", "俄罗斯联邦");
        map.put("FR", "法国");
        //通过key取值
        System.out.println("CN对应的国家是：" + map.get("CN"));
        //计算Map总数
        System.out.println("Map中共有" + map.size() + "组数据");
        //判断key是否存在
        System.out.println("Map中包含FR的Key吗？" + map.containsKey("FR"));
        //通过key删除
        map.remove("FR");
        System.out.println("Map中包含FR的Key吗？" + map.containsKey("FR"));
        //输出key
        System.out.println(map.keySet());
        //输出值
        System.out.println(map.values());
        //输出Map对象
        System.out.println(map);
        //全部清空
        map.clear();
        if (map.size() == 0) {
            System.out.println("已清空Map中的数据");
        } else {
            System.out.println("Map中共有" + map.size() + "组数据");
        }
    }
}
