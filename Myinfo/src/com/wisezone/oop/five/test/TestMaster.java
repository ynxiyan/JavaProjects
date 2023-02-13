package com.wisezone.oop.five.test;

import com.wisezone.oop.five.Dog;
import com.wisezone.oop.five.Master;
import com.wisezone.oop.five.Penguin;
import com.wisezone.oop.five.Pet;

/**
 * @Author: XIYAN
 * @Date: 2023/1/26 9:29
 * @注释:
 */
public class TestMaster {
    public static void main(String[] args) {
        Master master = new Master();
//        Dog dog = new Dog();
//        Penguin penguin = new Penguin();
//        //向上转型（子类转父类，自动）
        Pet petDog = new Dog();
        Pet petPenguin = new Penguin();
//        Pet petCat = new Cat();
//        master.feed(petDog);
//        master.feed(petPenguin);
//        master.feed(petCat);
        master.play(petDog);
        master.play(petPenguin);

//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入宠物类型：1.狗狗\t2.企鹅\t3.猫");
//        System.out.print("请选择：");
//        String typeId = input.next();
//        Pet pet = master.feed(typeId);
//        pet.eat();

    }
}
