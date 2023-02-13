package com.wisezone.oop.seven.animal.service.impl;

import com.wisezone.oop.seven.animal.Animal;
import com.wisezone.oop.seven.animal.service.Terrestrial;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 17:14
 * @注释:猫
 */
public class Cat extends Animal implements Terrestrial {

    public void setLegNum(int legNum) {
        if (legNum != 4) {
            throw new RuntimeException("猫的腿只有4条");
        } else {
            super.setLegNum(legNum);
        }
    }

    public Cat() {
    }

    /**
     * 叫
     */
    @Override
    public String show() {
        return "喵喵喵...";
    }

    public Cat(String name, int legNum) {
        super(name);
        super.setLegNum(legNum);

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
