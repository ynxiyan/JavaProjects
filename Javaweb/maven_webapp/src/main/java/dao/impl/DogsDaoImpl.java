package dao.impl;

import dao.DogsDao;
import entity.Dogs;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:06
 * @注释:继承BasicDao并实现DogsDao中所有的抽象方法
 */
public class DogsDaoImpl extends BasicDao implements DogsDao {
    @Override
    public Dogs selectDogsByid(Dogs dogs) {
        String sql = "select id,name,sex,age from dogs where id=?";
        return selectOne(Dogs.class, sql, dogs.getId());
    }
}
