package com.wisezone.oop.four;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 9:51
 * @注释:
 */
public class Penguins extends Pet {
    private String sex;
    static final String SEX_ONE = "Q仔";
    static final String SEX_TWO = "Q妹";

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void showPet() {
        System.out.println("我的名字叫" + getName() + "，健康值是" + getHelath() + "，和主人的亲密度是" + getLove() + "，性别是" + sex);
    }
}
