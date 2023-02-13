package com.itheima.design.demo1;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 14:18
 * @注释:搜狗输入法
 */
public class SouGouInput {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
