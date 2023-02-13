package com.wisezone.synthesis.test;

import java.util.ArrayList;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 9:10
 * @注释:
 */
public class TestRepeat {
    public static void main(String[] args) {
        String str = "1598674123423412";
        String[] sc1;
        ArrayList list = new ArrayList();
        sc1 = str.split("");
        for (int i = 0; i < str.length(); i++) {

            for (int j = i; j < str.length(); j++) {
                if (!list.contains(sc1[j])) {
                    list.add(sc1[j]);
                    break;
                }
            }
        }
        System.out.println(list);
    }
}
