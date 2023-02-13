package com.wisezone.features.one.test;

import com.wisezone.features.one.Penguin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 14:22
 * @注释:
 */
public class TestTwoPenguin {
    public static void main(String[] args) {
        Map<Integer, Penguin> map = new HashMap<>();
        map.put(1, new Penguin("欧欧", "Q仔"));
        map.put(2, new Penguin("亚亚", "Q妹"));
        map.put(3, new Penguin("菲菲", "Q妹"));
        map.put(4, new Penguin("美美", "Q妹"));
        System.out.println("使用Iterator遍历，所有企鹅的昵称和品种分别是：");
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(map.get(key));
        }
        System.out.println("\n使用forEach遍历，所有企鹅的昵称和品种分别是：");
        map.forEach((serial, list) -> {
            System.out.println(list);
        });
    }
}
