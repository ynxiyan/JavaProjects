package com.pet.service.impl;

import com.pet.dao.DogsDao;
import com.pet.dao.impl.DogsDaoImpl;
import com.pet.entity.Dogs;
import com.pet.service.DogsService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/15 11:26
 * @注释:DogsService实现类需要实现DogsService的所有抽象方法
 */
public class DogsServiceImpl implements DogsService {
    private final DogsDao dogsDao = new DogsDaoImpl();

    @Override
    public boolean addDogs(Dogs dogs) {
        return dogsDao.insertDogs(dogs) > 0;
    }

    @Override
    public boolean removeDogs(Dogs dogs) {
        return dogsDao.deleteDogs(dogs) > 0;
    }

    @Override
    public boolean modifyDogs(Dogs dogs, String name) {
        return dogsDao.updateDogs(dogs, name) > 0;
    }

    @Override
    public Dogs getDogsById(Dogs dogs) {
        return dogsDao.selectDogsById(dogs);
    }

    @Override
    public List<Dogs> getDogsAll() {
        return dogsDao.selectDogsAll();
    }

    @Override
    public List<Dogs> getDogLike(String like) {
        return dogsDao.selectDogLike(like);
    }
}
