package com.wisezone.seven;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/15 10:58
 * @注释:
 */
public class Insert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] word = {"a", "b", "c", "e", "f", "p", "u", "z", ""};
        int index = 0;
        System.out.print("原字符序列：");
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i] + " ");
        }
        System.out.print("\n待插入的字符是：");
        String letter = input.next();
        for (int i = 0; i < word.length; i++) {
            /**
             * compareTo();
             * 若Str1等于参数字符串Str2字符串，则返回0；
             * 若该Str1按字典顺序小于参数字符串Str2，则返回值小于0；
             * 若Str1按字典顺序大于参数字符串Str2，则返回值大于0。
             */
            boolean let = letter.compareTo(word[i]) < 0;
            if (let) {
                index = i;
                break;
            }
        }
        System.out.println("插入字符的下标是：" + index);
        for (int i = word.length - 1; i > index; i--) {
            word[i] = word[i - 1];
        }
        word[index] = letter;
        System.out.print("插入后的字符序列是：");
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i] + " ");
        }
    }
}
