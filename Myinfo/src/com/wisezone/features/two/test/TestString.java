package com.wisezone.features.two.test;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 10:10
 * @注释:
 */
public class TestString {
    @Test
    public void test() {
        String t1 = "y";
        String t2 = "Y";
        System.out.println(t1.equalsIgnoreCase(t2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.println("---欢迎进入作业提交系统---");
//        System.out.print("请输入Java文件名：");
//        String fileName = input.next();
//        int index = fileName.lastIndexOf(".java");
//        if (!".java".equals(fileName.substring(index == -1 ? 0 : index).toLowerCase())) {
//            System.out.println("文件名格式不正确");
//            return;
//        }
//        System.out.print("请输入你的邮箱：");
//        String email = input.next();
//        if (!(email.indexOf("@") > email.indexOf("."))) {
//            System.out.println("邮箱格式不正确");
//            return;
//        }
//        System.out.println("作业提交成功");
        //System.out.print("请输入一串数字:");
        String num = "123456789";
        StringBuffer sbt = new StringBuffer();
        sbt.append(num);
        for (int i = num.length(); i > 0; i = i - 3) {
            if (i != num.length()) {
                sbt.insert(i, ",");
            }
        }
        System.out.println(sbt);
    }

    @Test
    public void testSubtring() {
        String word = "Hello,      ";
        word = word.trim();
        String s = word.concat("小鱼儿！");
        int indexOne = s.indexOf(",");
        int indexTwo = s.indexOf("！");
        System.out.println(s.substring(indexOne + 1, indexTwo));
    }

    @Test
    public void testSplit() {
        System.out.println("原歌词：\nAnother way to be where you didn't want yourself to go");
        String oldSong = "Another way to be where you didn't want yourself to go";
        System.out.println("拆分后的歌词（通过空格拆分）:");
        String[] newSong = oldSong.split(" ");
        for (String str : newSong
        ) {
            System.out.println(str);
        }
    }
}
