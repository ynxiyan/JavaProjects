package com.service;

import com.model.City;
import com.model.Province;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 9:41
 * @注释:逻辑判断的省份和城市接口
 */
public interface ProvinceAndCityService {
    /**
     * 逻辑判断省份列表
     *
     * @return 返回省份列表
     */
    List<Province> getProvince();

    /**
     * 逻辑判断城市列表
     *
     * @param province 传入省份序号
     * @return 返回城市列表
     */
    List<City> getCity(Province province);
}
