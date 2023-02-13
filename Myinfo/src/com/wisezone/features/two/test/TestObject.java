package com.wisezone.features.two.test;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 9:40
 * @注释:
 */
public class TestObject {
    public static void main(String[] args) {
        //允许基本数据类型和包装类型进行混合数学运算
        Integer oneObject = 1;
        int two = 2;
        System.out.println(oneObject + two);
        //建议转成基本数据类型
        Integer one1 = 127;
        Integer one2 = 127;
        Integer one3 = 128;
        Integer one4 = 128;
        System.out.println();
        System.out.println(one1.equals(one2));
        //包装类转成原来基本数据类型 xxxValue()
        //字符串转 int Integer.parseXXX()
        System.out.println(one3.intValue() == one4.intValue());
    }
}
