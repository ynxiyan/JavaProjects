package com.pet.dao.impl;

import com.pet.dao.DogsDao;
import com.pet.entity.Dogs;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 17:24
 * @注释:DogsDao的实现类需要实现所有的抽象方法
 */
public class DogsDaoImpl extends BasicDao implements DogsDao {
    @Override
    public int insertDogs(Dogs dogs) {
        String sql = "insert into dogs(name,sex,age) values(?,?,?)";
        return update(sql, dogs.getName(), dogs.getSex(), dogs.getAge());
    }

    @Override
    public int deleteDogs(Dogs dogs) {
        String sql = "delete from dogs where id=?";
        return update(sql, dogs.getId());
    }

    @Override
    public int updateDogs(Dogs dogs, String name) {
        String sql = "update dogs set name=?,sex=?,age=? where name=?";
        return update(sql, dogs.getName(), dogs.getSex(), dogs.getAge(), name);
    }

    @Override
    public Dogs selectDogsById(Dogs dogs) {
        String sql = "select id,name,sex,age from dogs where id=?";
        return selectOne(Dogs.class, sql, dogs.getId());
    }

    @Override
    public List<Dogs> selectDogsAll() {
        String sql = "select id,name,sex,age from dogs";
        return selectList(Dogs.class, sql);
    }

    @Override
    public List<Dogs> selectDogLike(String like) {
        String sql = "select id,name,sex,age from dogs where name like?";
        return selectList(Dogs.class, sql, like);
    }
}
