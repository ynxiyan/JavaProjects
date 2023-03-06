package com.dao;

import com.model.City;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 9:38
 * @注释:省份和城市接口
 */
public interface ProvinceAndCityDao {
    /**
     * 查询省份列表
     *
     * @return 返回省份列表
     */
    List<com.model.Province> selectByProvince();

    /**
     * 查询城市列表
     *
     * @param province 传入省份序号
     * @return 返回城市列表
     */
    List<City> selectByCity(com.model.Province province);
}
