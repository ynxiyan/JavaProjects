package dao;

import entity.Dogs;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:02
 * @注释:Dogs抽象方法
 */
public interface DogsDao {
    /**
     * 通过id查询dogs的信息
     *
     * @param dogs 传入dogs的id
     * @return 返回查询到的结果
     */
    Dogs selectDogsByid(Dogs dogs);
}
