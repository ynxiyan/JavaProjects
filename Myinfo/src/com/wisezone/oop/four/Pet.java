package com.wisezone.oop.four;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 11:07
 * @注释:
 */
//抽象类
public abstract class Pet {
    //私有属性
    private String name;
    private int love;
    private int helath;

    //公有方法get(获取)/set(设置)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHelath() {
        return helath;
    }

    public void setHelath(int helath) {
        if (helath > 100 || helath < 0) {
            this.helath = 60;
            System.out.println("健康值应该在0至100之间，默认值为60");
        } else {
            this.helath = helath;
        }
    }

    /**
     * 抽象方法
     */
    public abstract void showPet();
}
