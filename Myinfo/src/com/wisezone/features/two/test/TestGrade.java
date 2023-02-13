package com.wisezone.features.two.test;

import com.wisezone.features.two.Grade;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 9:13
 * @注释:
 */
public class TestGrade {
    public static void main(String[] args) {
        switch (Grade.U1) {
            //小括号里可以用六种数据类型 byte 、 char 、 short 、 int 、 String 、 enum
            case U1:
                System.out.println("第一阶段打基础");
                break;
            case U2:
                System.out.println("第二阶段学习Java Web");
                break;
            case U3:
                System.out.println("第三阶段学习企业级框架");
            default:
                break;
        }
    }
}
