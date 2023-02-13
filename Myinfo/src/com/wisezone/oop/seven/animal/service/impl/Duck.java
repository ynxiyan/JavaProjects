package com.wisezone.oop.seven.animal.service.impl;

import com.wisezone.oop.seven.animal.Animal;
import com.wisezone.oop.seven.animal.service.Terrestrial;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 17:22
 * @注释:鸭子
 */
public class Duck extends Animal implements Terrestrial {

    public Duck() {
    }

    /**
     * 叫
     */
    @Override
    public String show() {
        return "嘎嘎嘎...";
    }

    public Duck(String name, int legNum) {
        super(name);
        super.setLegNum(legNum);
    }

    public void setLegNum(int legNum) {
        if (legNum != 2) {
            throw new RuntimeException("鸭子的腿只有2条");
        } else {
            super.setLegNum(legNum);
        }
    }

    /**
     * 腿的条数
     *
     * @return
     */
    @Override
    public int getLegNum() {
        return super.getLegNum();
    }

    @Override
    public String toString() {
        return " " + getName() + "\t\t" + getLegNum();
    }
}
