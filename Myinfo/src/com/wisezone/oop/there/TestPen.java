package com.wisezone.oop.there;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 9:08
 * @注释:
 */
public class TestPen {
    public static void main(String[] args) {
        //调用无参构造
        Penguin penguin = new Penguin();
        //调用带参构造
        //Penguin penguin = new Penguin("欧欧",100,100,"Q仔");
        penguin.show();
    }
}
