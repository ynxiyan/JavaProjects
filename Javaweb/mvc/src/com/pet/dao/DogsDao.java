package com.pet.dao;

import com.pet.entity.Dogs;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 17:12
 * @注释:设计操作entity中对象应该有的功能
 */
public interface DogsDao {
    /**
     * 新增
     *
     * @param dogs 传入新增的信息
     * @return 返回受影响的行数
     */
    int insertDogs(Dogs dogs);

    /**
     * 删除
     *
     * @param dogs 传入需要删除的Id
     * @return 返回受影响的行数
     */
    int deleteDogs(Dogs dogs);

    /**
     * 修改
     *
     * @param dogs 传入需要修改的信息
     * @param name 传入需要修改的名称
     * @return 返回受影响的行数
     */
    int updateDogs(Dogs dogs, String name);

    /**
     * 通过Id查询
     *
     * @param dogs 传入需要查询的Id
     * @return 返回查询的结果信息
     */
    Dogs selectDogsById(Dogs dogs);

    /**
     * 查询所有
     *
     * @return 返回查询的结果集信息
     */
    List<Dogs> selectDogsAll();

    /**
     * 模糊查询
     *
     * @param like 传入需要模糊查询的名称
     * @return 返回查询的结果集信息
     */
    List<Dogs> selectDogLike(String like);
}
