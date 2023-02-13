package com.wisezone.seven;

import java.util.Arrays;

/**
 * @Author: XIYAN
 * @Date: 2022/12/15 10:46
 * @注释:
 */
public class Sort {
    public static void main(String[] args) {
        String[] word = {"a", "c", "u", "b", "e", "p", "f", "z"};
        System.out.print("原字符序列：");
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i] + " ");
        }
        Arrays.sort(word);
        System.out.print("\n升序排序后：");
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i] + " ");
        }
        System.out.print("\n逆序输出为：");
        for (int i = word.length - 1; i >= 0; i--) {
            System.out.print(word[i] + " ");
        }
    }
}
