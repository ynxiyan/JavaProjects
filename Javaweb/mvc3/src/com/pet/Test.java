package com.pet;

import com.pet.dao.impl.DogsDaoImpl;
import com.pet.entity.Dogs;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 17:39
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        Dogs dogs = new Dogs();
        DogsDaoImpl dogsImpl = new DogsDaoImpl();
        dogs.setName("o");
        String like = "%" + dogs.getName() + "%";
//        String name = dogs.getName();
//        dogs.setName("o");
//        dogs.setSex("公");
//        dogs.setAge(19);
        //dogs.setId(9);
        //返回
        dogsImpl.selectDogLike(like).forEach(System.out::println);
    }
}
