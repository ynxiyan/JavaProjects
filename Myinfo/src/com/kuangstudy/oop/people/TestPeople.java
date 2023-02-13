package com.kuangstudy.oop.people;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:25
 * @注释:
 */
public class TestPeople {
    /*
    定义一个类People
    定义两个类Man 和Woman
    man有个属性是老婆,有一个方法是lol
    woman有个属性是老公,有一个方法是shopping,还有一个方法是生孩子
    生孩子(先判断是否有老公,如果有就创建一个对象,有返回值)
    男孩儿就调用lol
    女孩就调用shopping
     */
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        woman.setHusband(man);
        // 向上转型, 把woman类型转换为People类型,在调用子类Woman的方法
        People people = woman.children(0);
        //People people = woman.children(1);
        //People people = null;
        if (people == null) {
            System.out.println("无配偶");
        } else {
            // 向下转型,子类调用父类的方法
            if (people instanceof Man) {
                //强制类型转换
                Man boy = (Man) people;
                boy.lol();
            } else if (people instanceof Woman) {
                Woman girl = (Woman) people;
                girl.shopping();
            }
        }
    }
}
