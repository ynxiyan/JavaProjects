package com.qfedu.gather.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/1/13 17:57
 * @注释:假设顺序列表ArrayList中存储的元素是整型数字1~5，遍历每个元素，将每个元素顺序输出。
 */
public class Print {
    public static void main(String[] args) {
        //创建int集合
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        //迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
