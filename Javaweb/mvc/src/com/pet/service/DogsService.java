package com.pet.service;

import com.pet.entity.Dogs;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/15 11:20
 * @注释:逻辑层，只是调用了Dao，使其可以进行简单判断，但是一般换了一种叫法
 */
public interface DogsService {
    boolean addDogs(Dogs dogs);

    boolean removeDogs(Dogs dogs);

    boolean modifyDogs(Dogs dogs, String name);

    Dogs getDogsById(Dogs dogs);

    List<Dogs> getDogsAll();

    List<Dogs> getDogLike(String like);
}
