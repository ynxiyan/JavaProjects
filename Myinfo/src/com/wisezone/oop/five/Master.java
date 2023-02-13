package com.wisezone.oop.five;

/**
 * @Author: XIYAN
 * @Date: 2023/1/26 9:24
 * @注释:主人类
 */
public class Master {
    //    /**
//     * 给狗狗喂食
//     *
//     * @param dog
//     */
//    public void feed(Dog dog) {
//        dog.eat();
//    }
//
//    /**
//     * 给企鹅喂食
//     *
//     * @param penguin
//     */
//    public void feed(Penguin penguin) {
//        penguin.eat();
//    }

    /**
     * 基于继承的多态，第一种父类做方法参数实现多态
     *
     * @param pet
     */
    public void feed(Pet pet) {
        pet.eat();
    }

    /**
     * 第二种父类做返回值实现多态
     *
     * @param typeId
     * @return
     */
    public Pet feed(String typeId) {
        Pet pet = null;
        //简单工厂设计模式
        switch (typeId) {
            case "1":
                pet = new Dog();
                break;
            case "2":
                pet = new Penguin();
                break;
            case "3":
                pet = new Cat();
                break;
            default:
                break;
        }
        return pet;
    }

    /**
     * 和宠物玩耍
     *
     * @param pet
     */
    public void play(Pet pet) {
        //向下转型（父类转为子类，强转<instanceof>）
        //instanceof 判断是否有继承和实现关系 ， 判断是否是原来的同一个对象
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.catchingFlyDisc();
        } else if (pet instanceof Penguin) {
            Penguin penguin = (Penguin) pet;
            penguin.swimming();
        }
    }
}
