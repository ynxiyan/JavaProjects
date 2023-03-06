package com.service.impl;

import com.dao.ProvinceAndCityDao;
import com.dao.impl.ProvinceAndCityDaoImpl;
import com.model.City;
import com.model.Province;
import com.service.ProvinceAndCityService;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 9:43
 * @注释:实现逻辑判断的省份和城市接口
 */
public class ProvinceAndCityServiceImpl implements ProvinceAndCityService {
    private final ProvinceAndCityDao provinceAndCityDao = new ProvinceAndCityDaoImpl();

    @Override
    public List<Province> getProvince() {
        return provinceAndCityDao.selectByProvince();
    }

    @Override
    public List<City> getCity(Province province) {
        return provinceAndCityDao.selectByCity(province);
    }
}
