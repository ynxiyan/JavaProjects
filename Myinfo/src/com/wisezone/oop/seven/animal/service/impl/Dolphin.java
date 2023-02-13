package com.wisezone.oop.seven.animal.service.impl;

import com.wisezone.oop.seven.animal.Animal;
import com.wisezone.oop.seven.animal.service.Terrestrial;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 17:16
 * @注释:海豚
 */
public class Dolphin extends Animal implements Terrestrial {

    public Dolphin() {
    }

    /**
     * 叫
     */
    @Override
    public String show() {
        return "海豚音...";
    }

    public Dolphin(String name) {
        super(name);
    }

    /**
     * 腿的条数
     *
     * @return
     */
    @Override
    public int getLegNum() {
        return 0;
    }

    @Override
    public String toString() {
        return " " + getName() + "\t\t" + getLegNum();
    }
}
