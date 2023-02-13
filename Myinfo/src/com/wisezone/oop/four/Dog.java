package com.wisezone.oop.four;


/**
 * @Author: XIYAN
 * @Date: 2022/12/28 9:45
 * @注释:
 */
public class Dog extends Pet {
    private String strain;
    static final String VARIETY_ONE = "聪明的拉布拉多犬";
    static final String VARIETY_TWO = "酷酷的雪原瑞";

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    @Override //覆盖重写
    public void showPet() {
        System.out.println("我的名字叫" + getName() + "，健康值是" + getHelath() + "，和主人的亲密度是" + getLove() + "，我是一只" + strain);
    }
}
