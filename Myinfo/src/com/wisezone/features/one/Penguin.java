package com.wisezone.features.one;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 10:03
 * @注释:
 */
public class Penguin {
    private String name;
    private String sex;

    public Penguin() {
    }

    public Penguin(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + "\t\t" + sex;
    }
}
