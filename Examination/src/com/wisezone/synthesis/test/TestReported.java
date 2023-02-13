package com.wisezone.synthesis.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 10:43
 * @注释:
 */
public class TestReported {
    public static void main(String[] args) {
        String str = "dsihgioderijgeo";
        String[] sc1;
        ArrayList list = new ArrayList();
        Set set=new HashSet();
        //拆分字符串
        sc1 = str.split("");
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                //判断字符串中是否包含指定的字符或字符串
                if (!list.contains(sc1[j])) {
                    list.add(sc1[j]);
                    break;
                }
            }
        }
        System.out.println(list);
        for(int i = 0; i < sc1.length; i++){
            set.add(sc1[i]);
        }
        System.out.println(set);
    }
}
