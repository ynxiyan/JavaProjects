package service.impl;

import dao.DogsDao;
import dao.impl.DogsDaoImpl;
import entity.Dogs;
import service.DogsService;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:13
 * @注释:
 */
public class DogsServiceImpl implements DogsService {
    DogsDao dogsDao = new DogsDaoImpl();

    @Override
    public Dogs getDogsById(Dogs dogs) {
        return dogsDao.selectDogsByid(dogs);
    }
}
