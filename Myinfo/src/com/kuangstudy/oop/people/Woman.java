package com.kuangstudy.oop.people;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:23
 * @注释:女人
 */
public class Woman extends People {
    //woman有个属性是老公,有一个方法是shopping,还有一个方法是生孩子
    private Man husband;

    public Man getHusband() {
        return husband;
    }

    public void setHusband(Man husband) {
        this.husband = husband;
    }

    public void shopping() {
        System.out.println("shopping");
    }

    /**
     * 生孩子
     */
    public People children(int num) {
        //生孩子(先判断是否有老公,如果有就创建一个对象,有返回值)
        People people = new People();
        if (husband != null) {
            if (num == 0) {
                people = new Man();
            } else {
                people = new Woman();
            }
        }
        return people;
    }
}
