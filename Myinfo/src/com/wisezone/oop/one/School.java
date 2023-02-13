package com.wisezone.oop.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/17 20:24
 * @注释:学校类
 */
public class School {
    //属性
    String name;
    String classRoom;
    String computerNum;

    //方法
    public void showInfo() {
        System.out.println("学校的名称是：" + name + "学校教室数量：" + classRoom + "学校电脑数量：" + computerNum);
    }
}
